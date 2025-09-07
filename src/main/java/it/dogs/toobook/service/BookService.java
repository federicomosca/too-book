package it.dogs.toobook.service;

import java.time.LocalDate;
import java.util.List;

import it.dogs.toobook.model.domain.Book;

public interface BookService {
    
    Book addBook(Book book);
    Book updateBookDetails(Long id, Book book);
    void removeBook(Long id);
    Book pickABookById(Long id);
    List<Book> pickAllBooks();
    List<Book> searchABookByTitle(String title);
    List<Book> searchABookByAuthor(String lastName);
    List<Book> searchABookByGenre(String genre);
    List<Book> searchABookByReleaseDate(LocalDate releaseDate);
}
