package com.nelsonenterprises.rickandmortyapiteste.resources;

import com.nelsonenterprises.rickandmortyapiteste.DTO.LocationDTO;
import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import com.nelsonenterprises.rickandmortyapiteste.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/location")
public class LocationResource {

    @Autowired
    private LocationService service;

    @GetMapping
    public ResponseEntity<List<LocationDTO>> findAll() {
        List<LocationDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocationDTO> findById(@PathVariable String id){
        LocationDTO location = service.findById(id);
        return ResponseEntity.ok().body(location);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Location location) {
        service.create(location);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(location.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Void> update (@RequestBody LocationDTO location, @PathVariable String id) {
        service.update(location, id);
        return ResponseEntity.ok().build();
    }

}
