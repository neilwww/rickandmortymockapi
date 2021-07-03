package com.nelsonenterprises.rickandmortyapiteste.services;

import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import com.nelsonenterprises.rickandmortyapiteste.repositories.CharacterRepository;
import com.nelsonenterprises.rickandmortyapiteste.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository repo;

    public List<Character> findAll() {
        return repo.findAll();
    }

    public Character insert(Character obj) {
        return repo.insert(obj);
    }

    public Character findById(String id) {
        Optional<Character> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public Character update(Character obj) {
        Character newChar = findById(obj.getId());
        updateData(newChar, obj);
        return repo.save(newChar);
    }

    public void updateData(Character newChar, Character obj) {
        newChar.setName(obj.getName());
        newChar.setStatus(obj.getStatus());
        newChar.setSpecies(obj.getSpecies());
        newChar.setGender(obj.getGender());
        newChar.setImage(obj.getImage());
        newChar.setCreated(obj.getCreated());
    }

}
