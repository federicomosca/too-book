package it.dogs.toobook.repository;

import it.dogs.toobook.model.domain.Section;
import it.dogs.toobook.model.domain.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {

    Optional<Shelf> findByFriendlyName(String friendlyName);
    List<Shelf> findBySection(Section section);}
