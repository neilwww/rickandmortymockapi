package com.nelsonenterprises.rickandmortyapiteste.DTO;

import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CharacterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Character.Status status;
    private String species;
    private Character.Gender gender;
    private String origin;
    private String location;
    private String url;
    private LocalDateTime created = LocalDateTime.now();

    public CharacterDTO(Character.Status status, String species, Character.Gender gender, String origin, String location, String url) {
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.url = url;
    }

    public CharacterDTO (Character obj) {
        this.url = obj.getImage();
    }
}
