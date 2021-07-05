package com.nelsonenterprises.rickandmortyapiteste.domain;

import com.nelsonenterprises.rickandmortyapiteste.DTO.CharacterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}

