package com.nelsonenterprises.rickandmortyapiteste.config;

import com.nelsonenterprises.rickandmortyapiteste.DTO.CharacterDTO;
import com.nelsonenterprises.rickandmortyapiteste.DTO.LocationDTO;
import com.nelsonenterprises.rickandmortyapiteste.domain.Character;
import com.nelsonenterprises.rickandmortyapiteste.domain.Location;
import com.nelsonenterprises.rickandmortyapiteste.repositories.CharacterRepository;
import com.nelsonenterprises.rickandmortyapiteste.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private LocationRepository locationRepository;


    //Criar as coleções no banco
    @Override
    public void run(String[] args) throws Exception {

        locationRepository.deleteAll();
        characterRepository.deleteAll();

        Character c1= new Character("Mateus", Character.Status.Dead, "Human", Character.Gender.Male, "https://imgur.com/a/q7Vg5Na");
        Character c2 = new Character("Artorias", Character.Status.Alive, "Human", Character.Gender.Male, "https://darksouls.wiki.fextralife.com/file/Dark-Souls/artorias_header_full.jpg?v=1529081239468");
        Character c3 = new Character("Axe", Character.Status.Dead, "Diabo", Character.Gender.Male, "https://cdn.cloudflare.steamstatic.com/apps/dota2/images/dota_react/heroes/social/axe.jpg");

        Location l1 = new Location("Casa do Mateus", "Inferno", "https://imgur.com/a/disBSRn");
        Location l2 = new Location("Battle of stoicism", "Oolacile", "https://blogs-images.forbes.com/erikkain/files/2012/11/Death-of-Artorias.jpg");
        Location l3 = new Location("map", "Dota", "https://static.wikia.nocookie.net/dota2_gamepedia/images/8/8d/Labelled_Map_7.20.png/revision/latest/scale-to-width-down/528?cb=20181122205641");

        characterRepository.saveAll(Arrays.asList(c1,c2,c3));
        locationRepository.saveAll(Arrays.asList(l1,l2,l3));

        LocationDTO l1Dto = new LocationDTO(l1.getName(), l1.getDimension(), new CharacterDTO(c1), l1.getUrl());

    }
}
