package com.nelsonenterprises.rickandmortyapiteste.services;

import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import com.nelsonenterprises.rickandmortyapiteste.repositories.LocationRepository;
import com.nelsonenterprises.rickandmortyapiteste.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repo;

    public List<Location> findAll() {
        return repo.findAll();
    }

    public Location findById(String id) {
        Optional<Location> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public Location insert(Location obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {repo.deleteById(id);}


    public Location update(Location obj) {
        Location newLocation = findById(obj.getId());
        updateData(newLocation, obj);
        return repo.save(newLocation);

    }

    public void updateData(Location newLocation, Location obj) {
        newLocation.setName(obj.getName());
        newLocation.setDimension(obj.getDimension());
        newLocation.setUrl(obj.getUrl());
        newLocation.setCreated(obj.getCreated());
    }
}
