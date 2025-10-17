package it.dogs.toobook.repository;

import it.dogs.toobook.model.domain.Unit;
import it.dogs.toobook.model.domain.enums.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    Optional<Unit> findByFriendlyName(String friendlyName);
    Optional<Unit> findByRoom(Room room);}
