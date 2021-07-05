package com.nelsonenterprises.rickandmortyapiteste.repositories;

import com.nelsonenterprises.rickandmortyapiteste.DTO.LocationDTO;
import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}
