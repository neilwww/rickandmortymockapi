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
    private String url;
    private LocalDateTime created = LocalDateTime.now();

    public LocationDTO(Location obj) {
        this.name = name;
        this.url = url;
    }
}
