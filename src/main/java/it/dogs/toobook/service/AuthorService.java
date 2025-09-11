package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Author;

public interface AuthorService {
    Author createAuthor(Author author);
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
    Author getAuthorById(Long id);
    Author getAuthorByLastName(String lastName);
    Author getAuthorByFirstName(String firstName);
}
