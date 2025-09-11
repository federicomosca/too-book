package it.dogs.toobook.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.repository.BookRepository;
import it.dogs.toobook.service.BookService;

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
    public Book updateBook(Long id, Book newBook) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            bookToUpdate.setTitle(newBook.getTitle());
            bookToUpdate.setAuthor(newBook.getAuthor());
            bookToUpdate.setGenre(newBook.getGenre());
            bookToUpdate.setYear(newBook.getYear());
            bookToUpdate.setISBN(newBook.getISBN());
            bookToUpdate.setShelf(newBook.getShelf());
            bookToUpdate.setSection(newBook.getSection());
            bookToUpdate.setUnit(newBook.getUnit());
            return bookRepository.save(bookToUpdate);
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
    }

    @Override
    public Book pickABookById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickABookById'");
    }

    @Override
    public List<Book> pickAllBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickAllBooks'");
    }

    @Override
    public List<Book> searchABookByTitle(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchABookByTitle'");
    }

    @Override
    public List<Book> searchABookByAuthor(String lastName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchABookByAuthor'");
    }

    @Override
    public List<Book> searchABookByGenre(String genre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchABookByGenre'");
    }

    @Override
    public List<Book> searchABookByReleaseDate(LocalDate releaseDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchABookByReleaseDate'");
    }
    
}
