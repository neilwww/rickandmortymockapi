package com.nelsonenterprises.rickandmortyapiteste.DTO;

import com.nelsonenterprises.rickandmortyapiteste.domain.Character.GenderEnum;
import com.nelsonenterprises.rickandmortyapiteste.domain.Character.LocationData;
import com.nelsonenterprises.rickandmortyapiteste.domain.Character.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CharacterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private StatusEnum status;
    private String species;
    private GenderEnum gender;
    private LocationData origin;
    private LocationData location;
    private String url;
    private LocalDateTime created = LocalDateTime.now();

}
