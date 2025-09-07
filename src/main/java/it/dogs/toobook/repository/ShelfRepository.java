package it.dogs.toobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dogs.toobook.model.domain.Shelf;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
    
}
