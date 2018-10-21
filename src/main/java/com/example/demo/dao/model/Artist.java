package com.example.demo.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isBand;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE)
    private List<Song> songs;

    @OneToOne(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArtistProperty artistProperty;

    public Artist() {}

    public Artist(String name) {
        this.name = name;
    }
}
