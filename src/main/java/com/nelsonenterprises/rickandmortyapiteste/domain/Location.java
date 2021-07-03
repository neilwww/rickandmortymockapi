package com.nelsonenterprises.rickandmortyapiteste.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "location")
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String dimension;
    private List<Character> residents;
    private String url;
    private LocalDateTime created = LocalDateTime.now();

    public Location(String name, String dimension, String url) {
        this.name = name;
        this.dimension = dimension;
        this.url = url;
    }

}

