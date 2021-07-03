package com.nelsonenterprises.rickandmortyapiteste.resources;

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
    public ResponseEntity<List<Location>> findAll() {
        List<Location> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Location> findById(@PathVariable String id){
        Location location = service.findById(id);
        return ResponseEntity.ok().body(location);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Location location) {
        location = service.insert(location);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(location.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Void> update (@RequestBody Location location, @PathVariable String id) {
        location.setId(id);
        location = service.update(location);
        return ResponseEntity.noContent().build();
    }

}
