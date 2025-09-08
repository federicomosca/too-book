package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Author;

public interface AuthorService {
    Author addAuthor(Author author);

    Author updateAuthorDetails(Long id, Author author);

    void removeAuthor(Long id);

    Author getAuthorById(Long id);

    Author getAuthorByLastName(String lastName);

    Author getAuthorByFirstName(String firstName);
}
