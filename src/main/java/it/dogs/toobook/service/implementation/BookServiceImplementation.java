package it.dogs.toobook.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.model.domain.enums.Genre;
import it.dogs.toobook.repository.BookRepository;
import it.dogs.toobook.service.BookService;
import jakarta.persistence.EntityNotFoundException;

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
        bookRepository.findById(id).ifPresent(bookRepository::delete);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException(
            "Book with id " + id +" not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title)
        .orElseThrow(()-> new EntityNotFoundException(
            "Book with title" + title + " not found."
        ));
    }

    @Override
    public Book findBookByAuthor(Author author) {
        return bookRepository.findBookByAuthor(author)
        .orElseThrow(()-> new EntityNotFoundException(
            String.format("Book by the author %s %s not found", 
            author.getFirstName(), 
            author.getLastName())
        ));
    }

    @Override
    public Book findBookByGenre(Genre genre) {
        return bookRepository.findBookByGenre(genre).orElseThrow(
            ()-> new EntityNotFoundException(
                String.format("Book of genre %s not found", genre)
            )
        );
    }

    @Override
    public Book findBookByReleaseDate(LocalDate releaseDate) {
        return bookRepository.findBookByReleaseDate(releaseDate)
        .orElseThrow(()-> new EntityNotFoundException(
            String.format("Couldn't find any book released on %tY", releaseDate.getYear()) //rivedere colonna year in Book
        ));
    }    
}
