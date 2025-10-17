package it.dogs.toobook.service.implementation;

import it.dogs.toobook.model.domain.Section;
import it.dogs.toobook.model.domain.Unit;
import it.dogs.toobook.repository.SectionRepository;
import it.dogs.toobook.repository.UnitRepository;
import it.dogs.toobook.service.SectionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImplementation implements SectionService {

    private final SectionRepository sectionRepository;
    private final UnitRepository unitRepository;

    public SectionServiceImplementation(SectionRepository sectionRepository, UnitRepository unitRepository) {
        this.sectionRepository = sectionRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Section updateSection(Long id, Section section) {
        Section existing = getSectionById(id);
        existing.setFriendlyName(section.getFriendlyName());
        existing.setUnit(section.getUnit());
        return sectionRepository.save(existing);
    }

    @Override
    public void deleteSection(Long id) {
        Section section = getSectionById(id);
        sectionRepository.delete(section);
    }

    @Override
    public Section getSectionById(Long id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Section with id " + id + " not found"));
    }

    @Override
    public Section getSectionByFriendlyName(String friendlyName) {
        return sectionRepository.findByFriendlyName(friendlyName)
                .orElseThrow(() -> new EntityNotFoundException("Section '" + friendlyName + "' not found"));
    }

    @Override
    public List<Section> getSectionsByUnit(String unitFriendlyName) {
        Unit unit = unitRepository.findByFriendlyName(unitFriendlyName)
                .orElseThrow(() -> new EntityNotFoundException("Unit '" + unitFriendlyName + "' not found"));
        List<Section> sections = sectionRepository.findByUnit(unit);
        if (sections.isEmpty()) {
            throw new EntityNotFoundException("No sections in unit '" + unitFriendlyName + "'");
        }
        return sections;
    }
}
