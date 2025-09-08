package it.dogs.toobook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    @PutMapping
    public ResponseEntity<Book> updateBookDetails(@RequestBody Book book, Long id) {
        Book updatedBook = bookService.updateBookDetails(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeBook(@PathVariable Long id) {
        bookService.removeBook(id);
        return ResponseEntity.noContent().build();
    }
}
