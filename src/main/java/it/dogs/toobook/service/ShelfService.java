package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Shelf;

public interface ShelfService {
    Shelf addShelf(Shelf shelf);

    Shelf updateShelfDetails(Long id, Shelf shelf);

    void removeShelf(Long id);

    Shelf getShelfById(Long id);

    Shelf getShelfByFriendlyName(String friendlyName);
}
