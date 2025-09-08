package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Section;

public interface SectionService {
    Section addSection(Section section);

    Section updateSectionDetails(Long id, Section section);

    void removeSection(Long id);

    Section getSectionById(Long id);

    Section getSectionByFriendlyName(String friendlyName);

    Section getSectionByUnit(String unitFriendlyName);

    Section getSectionByShelf(String shelfFriendlyName);
}
