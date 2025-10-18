package it.dogs.toobook.service;

import it.dogs.toobook.model.domain.Unit;
import it.dogs.toobook.model.domain.enums.Room;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();
    Unit createUnit(Unit unit);
    Unit updateUnit(Long id, Unit unit);
    void deleteUnit(Long id);
    Unit getUnitById(Long id);
    Unit getUnitByFriendlyName(String friendlyName);
    Unit getUnitByRoom(Room room);
}
