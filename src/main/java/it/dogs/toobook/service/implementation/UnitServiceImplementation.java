package it.dogs.toobook.service.implementation;

import it.dogs.toobook.model.domain.Unit;
import it.dogs.toobook.model.domain.enums.Room;
import it.dogs.toobook.repository.UnitRepository;
import it.dogs.toobook.service.UnitService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImplementation implements UnitService {

    private final UnitRepository unitRepository;

    public UnitServiceImplementation(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public Unit updateUnit(Long id, Unit unit) {
        Unit existing = getUnitById(id);
        existing.setFriendlyName(unit.getFriendlyName());
        existing.setRoom(unit.getRoom());
        return unitRepository.save(existing);
    }

    @Override
    public void deleteUnit(Long id) {
        Unit unit = getUnitById(id);
        unitRepository.delete(unit);
    }

    @Override
    public Unit getUnitById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unit with id " + id + " not found"));
    }

    @Override
    public Unit getUnitByFriendlyName(String friendlyName) {
        return unitRepository.findByFriendlyName(friendlyName)
                .orElseThrow(() -> new EntityNotFoundException("Unit '" + friendlyName + "' not found"));
    }

    @Override
    public Unit getUnitByRoom(Room room) {
        return unitRepository.findByRoom(room)
                .orElseThrow(() -> new EntityNotFoundException("No unit in room " + room));
    }
}