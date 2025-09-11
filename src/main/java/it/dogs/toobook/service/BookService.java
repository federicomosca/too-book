package it.dogs.toobook.service;

import java.time.LocalDate;
import java.util.List;

import it.dogs.toobook.model.domain.Book;

public interface BookService {
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    List<Book> findBookByTitle(String title);
    // da ripensare questo metodo
    List<Book> findBookByAuthor(String lastName);
    List<Book> findBookByGenre(String genre);
    List<Book> findBookByReleaseDate(LocalDate releaseDate);
}
