package it.dogs.toobook.controller;

import it.dogs.toobook.model.domain.Unit;
import it.dogs.toobook.model.domain.enums.Room;
import it.dogs.toobook.service.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping("/add")
    public ResponseEntity<Unit> addUnit(@RequestBody Unit unit) {
        Unit created = unitService.createUnit(unit);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable Long id) {
        Unit unit = unitService.getUnitById(id);
        return ResponseEntity.ok(unit);
    }

    @GetMapping("/name/{friendlyName}")
    public ResponseEntity<Unit> getUnitByName(@PathVariable String friendlyName) {
        Unit unit = unitService.getUnitByFriendlyName(friendlyName);
        return ResponseEntity.ok(unit);
    }

    @GetMapping("/room/{room}")
    public ResponseEntity<Unit> getUnitByRoom(@PathVariable String room) {
        Unit unit = unitService.getUnitByRoom(Room.valueOf(room.toUpperCase()));
        return ResponseEntity.ok(unit);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Unit> updateUnit(@PathVariable Long id, @RequestBody Unit unit) {
        Unit updated = unitService.updateUnit(id, unit);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        unitService.deleteUnit(id);
        return ResponseEntity.noContent().build();
    }
}