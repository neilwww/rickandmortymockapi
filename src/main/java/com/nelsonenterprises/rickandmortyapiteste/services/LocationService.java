package com.nelsonenterprises.rickandmortyapiteste.services;

import com.nelsonenterprises.rickandmortyapiteste.DTO.LocationDTO;
import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
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
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CharacterRepository characterRepository;

    public List<LocationDTO> findAll() {
        List<Location> entities = locationRepository.findAll();
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public LocationDTO findById(String id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        return convertToDTO(location);

    }

    public Location create(Location location) {
        return locationRepository.insert(location);
    }

    public void delete(String id) {
        locationRepository.deleteById(id);
    }

    public void update(Location location) {
        Location newLoc = locationRepository.findById(location.getId()).orElseThrow(() -> new ObjectNotFoundException("Location not found"));
        updateData(newLoc, location);
        locationRepository.save(newLoc);

    }

    private LocationDTO convertToDTO(Location location) {
        List<Character> character = characterRepository.findAll().stream()
                .filter(c -> c.getLocation().equals(location.getId()))
                .collect(Collectors.toList());


        LocationDTO entity = new LocationDTO();

        String defaultLocationURL = "www.example.com/api/location/";

        entity.setId(location.getId());
        entity.setName(location.getName());
        entity.setDimension(location.getDimension());
        entity.setResidents(character);
        entity.setUrl(defaultLocationURL + location.getId());


        return entity;
    }

    private Location convertToBO(LocationDTO locationDTO) {
        Location entity = new Location();

        entity.setId(locationDTO.getId());
        entity.setName(locationDTO.getName());
        entity.setDimension(locationDTO.getDimension());
        entity.setUrl(locationDTO.getUrl());

        return entity;
    }
    private void updateData(Location newLoc, Location location){
        newLoc.setId(location.getId());
        newLoc.setName(location.getName());
        newLoc.setDimension(location.getDimension());
        newLoc.setUrl(location.getUrl());
        newLoc.setCreated(location.getCreated());
    }
}
