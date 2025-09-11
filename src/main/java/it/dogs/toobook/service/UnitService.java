package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Unit;

public interface UnitService {
    Unit createUnit(Unit unit);
    Unit updateUnit(Long id, Unit unit);
    void deleteUnit(Long id);
    Unit getUnitById(Long id);
    Unit getUnitByFriendlyName(String friendlyName);
    Unit getUnitByRoom(String room);
    Unit getUnitBySection(String sectionFriendlyName);
    Unit getUnitByShelf(String shelfFriendlyName);
}
