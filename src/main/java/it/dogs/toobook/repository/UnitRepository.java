package it.dogs.toobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dogs.toobook.model.domain.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    
}
