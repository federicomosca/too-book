package it.dogs.toobook.controller;

import it.dogs.toobook.model.domain.Shelf;
import it.dogs.toobook.service.ShelfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelves")
public class ShelfController {

    private final ShelfService shelfService;

    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

    @PostMapping("/add")
    public ResponseEntity<Shelf> addShelf(@RequestBody Shelf shelf) {
        Shelf created = shelfService.createShelf(shelf);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shelf> getShelfById(@PathVariable Long id) {
        Shelf shelf = shelfService.getShelfById(id);
        return ResponseEntity.ok(shelf);
    }

    @GetMapping("/name/{friendlyName}")
    public ResponseEntity<Shelf> getShelfByName(@PathVariable String friendlyName) {
        Shelf shelf = shelfService.getShelfByFriendlyName(friendlyName);
        return ResponseEntity.ok(shelf);
    }

    @GetMapping("/section/{sectionName}")
    public ResponseEntity<List<Shelf>> getShelvesBySection(@PathVariable String sectionName) {
        List<Shelf> shelves = shelfService.getShelvesBySection(sectionName);
        return ResponseEntity.ok(shelves);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Shelf> updateShelf(@PathVariable Long id, @RequestBody Shelf shelf) {
        Shelf updated = shelfService.updateShelf(id, shelf);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShelf(@PathVariable Long id) {
        shelfService.deleteShelf(id);
        return ResponseEntity.noContent().build();
    }
}