package cl.ejerciciojava.books.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.ejerciciojava.books.mvc.models.Book;
import cl.ejerciciojava.books.mvc.repositories.BookRepository;

@Service
public class BookService {
    // Agregando el book al repositorio como una dependencia
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setId(id);
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            System.out.println("El libro no existe");
        }
    }
}