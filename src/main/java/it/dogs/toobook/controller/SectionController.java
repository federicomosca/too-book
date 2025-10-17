package it.dogs.toobook.controller;

import it.dogs.toobook.model.domain.Section;
import it.dogs.toobook.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Section> addSection(@RequestBody Section section) {
        Section created = sectionService.createSection(section);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable Long id) {
        Section section = sectionService.getSectionById(id);
        return ResponseEntity.ok(section);
    }

    @GetMapping("/name/{friendlyName}")
    public ResponseEntity<Section> getSectionByName(@PathVariable String friendlyName) {
        Section section = sectionService.getSectionByFriendlyName(friendlyName);
        return ResponseEntity.ok(section);
    }

    @GetMapping("/unit/{unitName}")
    public ResponseEntity<List<Section>> getSectionsByUnit(@PathVariable String unitName) {
        List<Section> sections = sectionService.getSectionsByUnit(unitName);
        return ResponseEntity.ok(sections);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Section> updateSection(@PathVariable Long id, @RequestBody Section section) {
        Section updated = sectionService.updateSection(id, section);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
        return ResponseEntity.noContent().build();
    }
}