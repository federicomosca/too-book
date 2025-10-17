package it.dogs.toobook.service.implementation;

import it.dogs.toobook.model.domain.Section;
import it.dogs.toobook.model.domain.Shelf;
import it.dogs.toobook.repository.SectionRepository;
import it.dogs.toobook.repository.ShelfRepository;
import it.dogs.toobook.service.ShelfService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfServiceImplementation implements ShelfService {

    private final ShelfRepository shelfRepository;
    private final SectionRepository sectionRepository;

    public ShelfServiceImplementation(ShelfRepository shelfRepository, SectionRepository sectionRepository) {
        this.shelfRepository = shelfRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Shelf createShelf(Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    @Override
    public Shelf updateShelf(Long id, Shelf shelf) {
        Shelf existing = getShelfById(id);
        existing.setFriendlyName(shelf.getFriendlyName());
        existing.setSection(shelf.getSection());
        return shelfRepository.save(existing);
    }

    @Override
    public void deleteShelf(Long id) {
        Shelf shelf = getShelfById(id);
        shelfRepository.delete(shelf);
    }

    @Override
    public Shelf getShelfById(Long id) {
        return shelfRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shelf with id " + id + " not found"));
    }

    @Override
    public Shelf getShelfByFriendlyName(String friendlyName) {
        return shelfRepository.findByFriendlyName(friendlyName)
                .orElseThrow(() -> new EntityNotFoundException("Shelf '" + friendlyName + "' not found"));
    }

    @Override
    public List<Shelf> getShelvesBySection(String sectionFriendlyName) {
        Section section = sectionRepository.findByFriendlyName(sectionFriendlyName)
                .orElseThrow(() -> new EntityNotFoundException("Section '" + sectionFriendlyName + "' not found"));
        List<Shelf> shelves = shelfRepository.findBySection(section);
        if (shelves.isEmpty()) {
            throw new EntityNotFoundException("No shelves in section '" + sectionFriendlyName + "'");
        }
        return shelves;
    }
}
