package cl.ejerciciojava.books.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.ejerciciojava.books.mvc.models.Book;
import cl.ejerciciojava.books.mvc.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String reroute() {
        return "redirect:/books";
    }

    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index";
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    @RequestMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/show";
    }

    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            Long id = book.getId();
            String title = book.getTitle();
            String description = book.getDescription();
            String language = book.getLanguage();
            Integer numberOfPages = book.getNumberOfPages();
            bookService.updateBook(id, title, description, language, numberOfPages);
            return "redirect:/books";
        }
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
