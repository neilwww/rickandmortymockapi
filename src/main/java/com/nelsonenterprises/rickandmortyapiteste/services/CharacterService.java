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

    public Character create(Character character) {
        return characterRepository.insert(character);
    }

    public void delete(String id) {
        characterRepository.deleteById(id);
    }

    public void update(Character character) {
        Character newCharacter = characterRepository.findById(character.getId()).orElseThrow(() -> new ObjectNotFoundException("Character not found"));
        updateData(newCharacter, character);
        characterRepository.save(newCharacter);

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
        entity.setLocation(new LocationData(location.getName(), defaultLocationURL + location.getId()));
        entity.setUrl(defaultcharURL + character.getId());
        return entity;
    }

    private Character convertToBO(CharacterDTO dto) {

        Character character = new Character();

        character.setId(dto.getId());
        character.setName(dto.getName());
        character.setStatus(dto.getStatus());
        character.setSpecies(dto.getSpecies());
        character.setGender(dto.getGender());
        character.setUrl(dto.getUrl());
        return character;

    }

    private void updateData(Character newChar, Character character) {
        newChar.setId(character.getId());
        newChar.setName(character.getName());
        newChar.setStatus(character.getStatus());
        newChar.setSpecies(character.getSpecies());
        newChar.setGender(character.getGender());
        newChar.setOrigin(character.getOrigin());
        newChar.setLocation(character.getLocation());
        newChar.setUrl(character.getUrl());

    }

}


