package it.dogs.toobook.repository;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.model.domain.Book;
import it.dogs.toobook.model.domain.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByTitle(String title);
    List<Book> findBookByAuthor(Author author);
    List<Book> findBookByGenre(Genre genre);
    List<Book> findBookByPublicationYear(int publicationYear);
}
