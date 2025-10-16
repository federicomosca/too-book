package it.dogs.toobook.service.implementation;

import it.dogs.toobook.model.domain.Section;
import it.dogs.toobook.model.domain.Shelf;
import it.dogs.toobook.model.domain.Unit;
import it.dogs.toobook.repository.SectionRepository;
import it.dogs.toobook.repository.ShelfRepository;
import it.dogs.toobook.repository.UnitRepository;
import it.dogs.toobook.service.SectionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectionServiceImplementation implements SectionService {

    private final SectionRepository sectionRepository;
    private final UnitRepository unitRepository;
    private final ShelfRepository shelfRepository;

    public SectionServiceImplementation(SectionRepository sectionRepository, UnitRepository unitRepository, ShelfRepository shelfRepository){
        this.sectionRepository = sectionRepository;
        this.unitRepository = unitRepository;
        this.shelfRepository = shelfRepository;
    }

    @Override
    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Section updateSection(Long id, Section section) {
        Section existingSection = getSectionById(id);
        existingSection.setFriendlyName(section.getFriendlyName());
        existingSection.setUnit(section.getUnit());
        return sectionRepository.save(existingSection);
    }

    @Override
    public void deleteSection(Long id) {
        Section sectionToDelete = getSectionById(id);
        sectionRepository.delete(sectionToDelete);
    }

    @Override
    public Section getSectionById(Long id) {
        return sectionRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(
                        String.format("Section with id %d not found", id))
        );
    }

    @Override
    public Section getSectionByFriendlyName(String friendlyName) {
        return sectionRepository.findByFriendlyName(friendlyName).orElseThrow(
                ()-> new EntityNotFoundException(
                        String.format("Section with friendly name %s not found", friendlyName))
        );
    }

    @Override
    public Section getSectionByUnit(String unitFriendlyName) {
        Optional<Unit> unit = unitRepository.findByFriendlyName(unitFriendlyName);
        if(unit.isPresent()){
            return sectionRepository.findByUnit(unit.get()).orElseThrow(
                    ()-> new EntityNotFoundException(
                            String.format("Section of unit %s not found", unitFriendlyName))
            );
        }else{
            throw new EntityNotFoundException(
                    String.format("Unit with friendly name %s not found", unitFriendlyName)
            );
        }
    }
}
