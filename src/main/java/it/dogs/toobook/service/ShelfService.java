package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf createShelf(Shelf shelf);
    Shelf updateShelf(Long id, Shelf shelf);
    void deleteShelf(Long id);
    Shelf getShelfById(Long id);
    Shelf getShelfByFriendlyName(String friendlyName);
    List<Shelf> getShelvesBySection(String sectionFriendlyName);
}
