package com.nelsonenterprises.rickandmortyapiteste.domain;

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
    private StatusEnum status;
    private String species;
    private GenderEnum gender;
    private String origin;
    private String location;
    private String url;
    private LocalDateTime created = LocalDateTime.now();

    public enum StatusEnum {
        UNKNOWN,
        ALIVE,
        DEAD,
    }

    public enum GenderEnum {

        FEMALE,
        MALE,
        GENDERLESS
    }
    @Data
    @AllArgsConstructor
    public static class LocationData  {

        private String name;
        private String url;
    }



}
