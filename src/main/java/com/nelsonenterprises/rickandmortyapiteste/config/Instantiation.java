package com.nelsonenterprises.rickandmortyapiteste.config;

import com.nelsonenterprises.rickandmortyapiteste.repositories.CharacterRepository;
import com.nelsonenterprises.rickandmortyapiteste.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private LocationRepository locationRepository;

    //Criar as coleções no banco
    @Override
    public void run(String[] args) throws Exception {

        characterRepository.deleteAll();

    }
}

