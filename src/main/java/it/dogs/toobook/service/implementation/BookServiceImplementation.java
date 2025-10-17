package it.dogs.toobook.service.implementation;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.model.domain.enums.Genre;
import it.dogs.toobook.repository.BookRepository;
import it.dogs.toobook.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existing = getBookById(id);
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setGenre(book.getGenre());
        existing.setPublicationYear(book.getPublicationYear());
        existing.setISBN(book.getISBN());
        existing.setShelf(book.getShelf());
        return bookRepository.save(existing);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + id + " not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException("Book '" + title + "' not found"));
    }

    @Override
    public List<Book> findBooksByAuthor(Author author) {
        List<Book> books = bookRepository.findBookByAuthor(author);
        if (books.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No books by %s %s", author.getFirstName(), author.getLastName()));
        }
        return books;
    }

    @Override
    public List<Book> findBooksByGenre(Genre genre) {
        List<Book> books = bookRepository.findBookByGenre(genre);
        if (books.isEmpty()) {
            throw new EntityNotFoundException("No books of genre " + genre);
        }
        return books;
    }

    @Override
    public List<Book> findBooksByPublicationYear(int year) {
        List<Book> books = bookRepository.findBookByPublicationYear(year);
        if (books.isEmpty()) {
            throw new EntityNotFoundException("No books from " + year);
        }
        return books;
    }
}

