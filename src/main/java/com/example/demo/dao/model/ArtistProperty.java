package com.example.demo.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ArtistProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer awardsNumber;

    @Column(nullable = false)
    private String debutYear;

    @Column(nullable = false)
    private Short memberNumber;

    @OneToOne
    @JoinColumn(name = "ARTIST_ID")
    private Artist artist;
}
