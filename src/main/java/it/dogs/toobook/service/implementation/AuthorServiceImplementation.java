package it.dogs.toobook.service.implementation;

import it.dogs.toobook.model.domain.Author;
import it.dogs.toobook.repository.AuthorRepository;
import it.dogs.toobook.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author newAuthor) {
        Author existingAuthor = getAuthorById(id);
        existingAuthor.setFirstName(newAuthor.getFirstName());
        existingAuthor.setLastName(newAuthor.getLastName());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.findById(id).ifPresent(authorRepository::delete);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Author with id " + id + " not found"));
    }

    @Override
    public Author getAuthorByLastName(String lastName) {
        return authorRepository.findByLastName(lastName).orElseThrow(
                () -> new EntityNotFoundException("Author with last name " + lastName + " not found")
        );
    }

    @Override
    public Author getAuthorByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName).orElseThrow(
                () -> new EntityNotFoundException("Author with first name " + firstName + " not found")
        );
    }

    @Override
    public Author getAuthorByFullName(String fullName) {
        return authorRepository.findByFullName(fullName).orElseThrow(
                () -> new EntityNotFoundException("Author with full name " + fullName + " not found")
        );
    }
}
