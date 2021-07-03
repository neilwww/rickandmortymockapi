package com.nelsonenterprises.rickandmortyapiteste.domain;

import com.nelsonenterprises.rickandmortyapiteste.DTO.LocationDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Document(collection = "character")
public class Character implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private Status status;
    private String species;
    private Gender gender;
    @DBRef
    private LocationDTO origin;
    @DBRef
    private LocationDTO location;
    private String image;
    private LocalDateTime created = LocalDateTime.now();

    public enum Status {
        Unknown,
        Alive,
        Dead,
    }

    public enum Gender {

        Female,
        Male,
        Genderless
    }

    public Character(String name, Status status, String species, Gender gender, String image) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.image = image;
    }

    public Character(String name, Status status, String species, Gender gender, LocationDTO origin, LocationDTO location, String image) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
    }
}
