package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.model.domain.enums.Genre;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book findBookByTitle(String title);
    List<Book> findBookByAuthor(Author author);
    List<Book> findBookByGenre(Genre genre);
    List<Book> findBookByPublicationYear(int publicationYear);
}
