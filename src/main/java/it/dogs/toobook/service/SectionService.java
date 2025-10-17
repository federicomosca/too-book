package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Section;

import java.util.List;

public interface SectionService {
    Section createSection(Section section);
    Section updateSection(Long id, Section section);
    void deleteSection(Long id);
    Section getSectionById(Long id);
    Section getSectionByFriendlyName(String friendlyName);
    List<Section> getSectionsByUnit(String unitFriendlyName);
}
