package cl.ejerciciojava.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.ejerciciojava.dojooverflow.models.Answer;
import cl.ejerciciojava.dojooverflow.models.Question;
import cl.ejerciciojava.dojooverflow.models.Tag;
import cl.ejerciciojava.dojooverflow.repositories.AnswerRepository;
import cl.ejerciciojava.dojooverflow.repositories.Questionrepository;
import cl.ejerciciojava.dojooverflow.repositories.TagRepository;

@Service
public class DojoOverflowService {
    private Questionrepository questionRepository;
    private TagRepository tagRepository;
    private AnswerRepository answerRepository;

    public DojoOverflowService(Questionrepository questionRepository, TagRepository tagRepository,
            AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
        this.answerRepository = answerRepository;
    }

    public Question findQuestion(Long id) {
        return questionRepository.findQuestionById(id);
    }

    public List<Question> allQuestion() {
        return questionRepository.findAll();
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> allTags() {
        return (List<Tag>) tagRepository.findAll();
    }

    public List<String> getAllTagSubjects() {
        List<String> tagsSubject = new ArrayList<>();
        for (Tag tag : tagRepository.findAll()) {
            tagsSubject.add(tag.getSubject());
        }
        return tagsSubject;
    }

    public void addTagToQuestion(Question question, Tag tag) {
        question.getTags().add(tag);
        questionRepository.save(question);
        tagRepository.save(tag);
    }

    public Tag findTagBySubjec(String subject) {
        for (Tag tag : tagRepository.findAll()) {
            if (tag.getSubject().equals(subject)) {
                return tag;
            }
        }
        return null;
    }

    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public void addAnswerToQuestion(Answer answer, Question question) {
        answer.setQuestion(question);
        answerRepository.save(answer);
    }
}
