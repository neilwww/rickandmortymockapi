package com.nelsonenterprises.rickandmortyapiteste.resources;


import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import com.nelsonenterprises.rickandmortyapiteste.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/character")
public class CharacterResource {

    @Autowired
    private CharacterService service;

    @GetMapping
    public ResponseEntity<List<Character>> findAll() {
        List<Character> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Character> findById(@PathVariable String id) {
        Character character = service.findById(id);
        return ResponseEntity.ok().body(character);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Character character) {
        character = service.insert(character);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(character.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Character character, @PathVariable String id) {
        character.setId(id);
        character = service.update(character);
        return ResponseEntity.noContent().build();
    }
}
