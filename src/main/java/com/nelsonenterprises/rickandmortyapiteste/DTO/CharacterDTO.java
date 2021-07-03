package com.nelsonenterprises.rickandmortyapiteste.DTO;

import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CharacterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String url;

    public CharacterDTO (Character obj) {
        this.url = obj.getImage();
    }
}
