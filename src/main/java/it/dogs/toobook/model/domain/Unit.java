package it.dogs.toobook.model.domain;

import java.util.List;

import it.dogs.toobook.model.domain.enums.Room;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "units")
public class Unit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Room room;

    @OneToMany(mappedBy = "unit")
    private List<Section> sections;

    @OneToMany(mappedBy = "unit")
    private List<Shelf> shelves;
}
