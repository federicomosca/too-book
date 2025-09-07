package it.dogs.toobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dogs.toobook.model.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
