package com.nelsonenterprises.rickandmortyapiteste.DTO;

import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String dimension;
    private List<Character> residents;
    private String url;
    private LocalDateTime created = LocalDateTime.now();

}
