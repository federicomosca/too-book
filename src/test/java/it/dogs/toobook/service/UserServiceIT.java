package it.dogs.toobook.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.repository.AuthorRepository;
import it.dogs.toobook.repository.BookRepository;

@SpringBootTest
public class UserServiceIT {

    private final BookService bookService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public UserServiceIT(BookService bookService,
            BookRepository bookRepository,
            AuthorRepository authorRepository) {

        this.bookService = bookService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;

    }

    @BeforeEach
    void setup() {
        bookRepository.deleteAll(); // clean DB before each test
        authorRepository.deleteAll();
    }

    @Test
    void createBook_savesBook() {
        Author georgeOrwell = new Author();
        georgeOrwell.setFirstName("George");
        georgeOrwell.setLastName("Orwell");
        georgeOrwell = authorRepository.save(georgeOrwell);

        Book book = new Book();
        book.setTitle("1984");
        book.setAuthor(georgeOrwell);

        Book saved = bookService.addBook(book);

        assertNotNull(saved.getId());
        assertEquals("1984", saved.getTitle());
        assertEquals("George", georgeOrwell.getFirstName());
        assertEquals("Orwell", georgeOrwell.getLastName());

        Optional<Book> fromDb = bookRepository.findById(saved.getId());
        assertTrue(fromDb.isPresent());
        assertEquals("George", fromDb.get().getAuthor().getFirstName());
        assertEquals("Orwell", fromDb.get().getAuthor().getLastName());
    }
}
