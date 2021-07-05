package com.nelsonenterprises.rickandmortyapiteste.resources;


import com.nelsonenterprises.rickandmortyapiteste.DTO.CharacterDTO;
import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import com.nelsonenterprises.rickandmortyapiteste.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/character")
public class CharacterResource {

    @Autowired
    private CharacterService service;

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> findAll() {
        List<CharacterDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CharacterDTO> findById(@PathVariable String id) {
        CharacterDTO character = service.findById(id);
        return ResponseEntity.ok().body(character);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Character character) {
        character = service.create(character);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(character.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody CharacterDTO dto, @PathVariable String id) {
        service.update(dto, id);
        return ResponseEntity.ok().build();
    }
}
