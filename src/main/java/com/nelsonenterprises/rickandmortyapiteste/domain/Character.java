package com.nelsonenterprises.rickandmortyapiteste.domain;

import com.nelsonenterprises.rickandmortyapiteste.DTO.LocationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "character")
public class Character implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private Status status;
    private String species;
    private Gender gender;
    private Location origin;
    private Location location;
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


}
