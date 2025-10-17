package it.dogs.toobook.repository;

import it.dogs.toobook.model.domain.Section;
import it.dogs.toobook.model.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    Optional<Section> findByFriendlyName(String friendlyName);
    List<Section> findByUnit(Unit unit);
}
