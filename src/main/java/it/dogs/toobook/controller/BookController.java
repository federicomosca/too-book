package it.dogs.toobook.controller;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.model.domain.enums.Genre;
import it.dogs.toobook.service.AuthorService;
import it.dogs.toobook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("add")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        Book addedBook = bookService.createBook(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    @GetMapping("list")
    public ResponseEntity<List<Book>> pickAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("pick/{id}")
    public ResponseEntity<Book> pickABookById(@PathVariable Long id) {
        Book selectedBook = bookService.getBookById(id);
        return ResponseEntity.ok(selectedBook);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Book> updateBookDetails(@PathVariable Long id, @RequestBody Book newBookDetails) {
        Book updatedBook = bookService.updateBook(id, newBookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> removeBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // Add these to BookController

    @GetMapping("/search/title")
    public ResponseEntity<Book> searchByTitle(@RequestParam String title) {
        Book book = bookService.findBookByTitle(title);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/search/author")
    public ResponseEntity<List<Book>> searchByAuthor(@RequestParam String authorName,
                                                     @Autowired AuthorService authorService) {
        Author author = authorService.getAuthorByFullName(authorName);
        List<Book> books = bookService.findBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/genre")
    public ResponseEntity<List<Book>> searchByGenre(@RequestParam Genre genre) {
        List<Book> books = bookService.findBooksByGenre(genre);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/year")
    public ResponseEntity<List<Book>> searchByYear(@RequestParam int year) {
        List<Book> books = bookService.findBooksByPublicationYear(year);
        return ResponseEntity.ok(books);
    }
}
