package com.nelsonenterprises.rickandmortyapiteste.services;

import com.nelsonenterprises.rickandmortyapiteste.DTO.CharacterDTO;
import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import com.nelsonenterprises.rickandmortyapiteste.domain.Character.LocationData;
import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import com.nelsonenterprises.rickandmortyapiteste.repositories.CharacterRepository;
import com.nelsonenterprises.rickandmortyapiteste.repositories.LocationRepository;
import com.nelsonenterprises.rickandmortyapiteste.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private LocationRepository locationRepository;

    public List<CharacterDTO> findAll() {
        List<Character> entities = characterRepository.findAll();
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CharacterDTO findById(String id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
        return convertToDTO(character);
    }

    public Character create(Character obj) {
        return characterRepository.insert(obj);
    }

    public void delete(String id) {
        characterRepository.deleteById(id);
    }

    //Arrumar bug que criar objeto novo em vez de atualizar o antigo
    public void update(CharacterDTO characterDTO, String Id) {
        try {
            CharacterDTO currentChar = findById(characterDTO.getId());
        }
        catch (ObjectNotFoundException e) {
            throw new IllegalArgumentException("Character not Found");
        }

        Character character = convertToBO(characterDTO);
        character.setId(characterDTO.getId());
        characterRepository.save(character);


    }

    private CharacterDTO convertToDTO(Character character) {
        Location origin = locationRepository.findById(character.getOrigin()).get();
        Location location = locationRepository.findById(character.getLocation()).get();

        CharacterDTO entity = new CharacterDTO();

        String defaultcharURL = "www.example.com/api/character/";

        String defaultLocationURL = "www.example.com/api/location/";

        entity.setId(character.getId());
        entity.setName(character.getName());
        entity.setStatus(character.getStatus());
        entity.setSpecies(character.getSpecies());
        entity.setGender(character.getGender());
        entity.setOrigin(new LocationData(origin.getName(), defaultLocationURL + origin.getId()));
        entity.setLocation(new LocationData(location.getName(),defaultLocationURL + location.getId()));
        entity.setUrl(defaultcharURL + character.getId());
        return entity;
    }
    private Character convertToBO (CharacterDTO dto) {
        LocationData origin = dto.getOrigin();
        LocationData location = dto.getLocation();

        Character character = new Character();

        character.setId(dto.getId());
        character.setName(dto.getName());
        character.setStatus(dto.getStatus());
        character.setSpecies(dto.getSpecies());
        character.setGender(dto.getGender());
        character.setOrigin(String.valueOf(new LocationData(origin.getName(), origin.getUrl())));
        character.setLocation(String.valueOf(location));
        character.setUrl(dto.getUrl());
        return character;

    }

}


