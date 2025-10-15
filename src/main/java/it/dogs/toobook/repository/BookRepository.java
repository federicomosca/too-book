package it.dogs.toobook.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.model.domain.enums.Genre;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByTitle(String title);
    Optional<Book> findBookByAuthor(Author author);
    Optional<Book> findBookByGenre(Genre genre);
    Optional<Book> findBookByReleaseDate(LocalDate releaseDate);
}
