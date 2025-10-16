package it.dogs.toobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.dogs.toobook.model.domain.Author;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE CONCAT(a.firstName, ' ', a.lastName) = :fullName")
    Optional<Author> findByFullName(@Param("fullName") String fullName);

    Optional<Author> findByFirstName(String firstName);
    Optional<Author> findByLastName(String lastName);
}
