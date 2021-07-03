package com.nelsonenterprises.rickandmortyapiteste.DTO;

import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LocationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String dimension;
    private String[] residents;
    private String url;

    private LocalDateTime created = LocalDateTime.now();

    public LocationDTO(Location obj) {
        name = obj.getName();
        url = obj.getUrl();
    }

    public LocationDTO(String name, String dimension, String[] residents, String url) {
        this.name = name;
        this.dimension = dimension;
        this.residents = residents;
        this.url = url;
    }

    public LocationDTO(String name, String dimension, CharacterDTO characterDTO, String url) {
    }
}
