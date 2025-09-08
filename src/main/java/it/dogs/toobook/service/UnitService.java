package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Unit;

public interface UnitService {

    Unit addUnit(Unit unit);

    Unit updateUnitDetails(Long id, Unit unit);

    void removeUnit(Long id);

    Unit getUnitById(Long id);

    Unit getUnitByFriendlyName(String friendlyName);

    Unit getUnitByRoom(String room);

    Unit getUnitBySection(String sectionFriendlyName);

    Unit getUnitByShelf(String shelfFriendlyName);
}
