package it.dogs.toobook.service;

import java.time.LocalDate;
import java.util.List;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.model.domain.enums.Genre;

public interface BookService {
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book findBookByTitle(String title);
    Book findBookByAuthor(Author author);
    Book findBookByGenre(Genre genre);
    Book findBookByReleaseDate(LocalDate releaseDate);
}
