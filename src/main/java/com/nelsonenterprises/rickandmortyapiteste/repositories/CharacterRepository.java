package com.nelsonenterprises.rickandmortyapiteste.repositories;

import com.nelsonenterprises.rickandmortyapiteste.DTO.CharacterDTO;
import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CharacterRepository extends MongoRepository<Character, String> {
}
