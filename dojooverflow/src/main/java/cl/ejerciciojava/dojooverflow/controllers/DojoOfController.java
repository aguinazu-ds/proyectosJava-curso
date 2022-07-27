package cl.ejerciciojava.dojooverflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.ejerciciojava.dojooverflow.models.Answer;
import cl.ejerciciojava.dojooverflow.models.Question;
import cl.ejerciciojava.dojooverflow.models.Tag;
import cl.ejerciciojava.dojooverflow.models.TagList;
import cl.ejerciciojava.dojooverflow.services.DojoOverflowService;

@Controller
public class DojoOfController {
    private final DojoOverflowService dojoOverflowService;

    public DojoOfController(DojoOverflowService dojoOverflowService) {
        this.dojoOverflowService = dojoOverflowService;
    }

    @RequestMapping("/questions")
    public String questionsPage(Model model) {
        model.addAttribute("questions", dojoOverflowService.allQuestion());
        return "questionDashboard";
    }

    @RequestMapping("/questions/new")
    public String addNewQuestion(@ModelAttribute("newQuestion") Question question) {
        return "newQuestionPage";
    }

    @PostMapping("/questions/new")
    public String addQuestion(@Validated @ModelAttribute("newQuestion") Question question, BindingResult result,
            @RequestParam("tagList") String tags) {
        if (result.hasErrors()) {
            return "newQuestionPage";
        }
        TagList list = new TagList(tags);
        Question newQuestion = dojoOverflowService.addQuestion(question);
        for (String tag : list.getTags()) {
            if (!dojoOverflowService.getAllTagSubjects().contains(tag)) {
                Tag newTag = new Tag(tag);
                dojoOverflowService.addTag(newTag);
                newQuestion.getTags();
                dojoOverflowService.addTagToQuestion(newQuestion, newTag);
            } else {
                dojoOverflowService.addTagToQuestion(newQuestion, dojoOverflowService.findTagBySubjec(tag));
            }
        }
        return "redirect:/questions";
    }

    @RequestMapping("/questions/{id}")
    public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("newAnswer") Answer answer) {
        model.addAttribute("question", dojoOverflowService.findQuestion(id));
        // for (Answer answers : dojoOverflowService.findQuestion(id).getAnswers()) {
        // System.out.println(answer);
        // }
        model.addAttribute("answers", dojoOverflowService.findQuestion(id).getAnswers());
        return "question";
    }

    @PostMapping(value = "/questions/{id}")
    public String addAnswer(@Validated @ModelAttribute("newAnswer") Answer answer, BindingResult result,
            @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "question";
        }
        dojoOverflowService.addAnswer(answer);
        dojoOverflowService.addAnswerToQuestion(answer, dojoOverflowService.findQuestion(id));

        return "redirect:/questions/{id}";
    }

}
