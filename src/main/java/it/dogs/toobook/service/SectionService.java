package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Section;

public interface SectionService {
    Section createSection(Section section);
    Section updateSection(Long id, Section section);
    void deleteSection(Long id);
    Section getSectionById(Long id);
    Section getSectionByFriendlyName(String friendlyName);
    Section getSectionByUnit(String unitFriendlyName);
    Section getSectionByShelf(String shelfFriendlyName);
}
