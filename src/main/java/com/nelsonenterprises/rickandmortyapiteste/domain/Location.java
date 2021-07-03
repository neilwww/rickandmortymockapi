package com.nelsonenterprises.rickandmortyapiteste.domain;

import com.nelsonenterprises.rickandmortyapiteste.DTO.CharacterDTO;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.print.DocFlavor;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "location")
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String dimension;
    @DBRef
    private CharacterDTO[] residents;
    private String url;
    private LocalDateTime created = LocalDateTime.now();

    public Location(String name, String dimension, String url) {
        this.name = name;
        this.dimension = dimension;
        this.url = url;
    }
}

