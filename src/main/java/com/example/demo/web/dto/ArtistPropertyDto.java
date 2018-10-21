package com.example.demo.web.dto;

import com.example.demo.dao.model.ArtistProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ArtistPropertyDto implements Serializable {

    private Long id;

    private Integer awardsNumber;

    private String debutYear;
    
    private Short memberNumber;

    public ArtistPropertyDto fromEntity(ArtistProperty artistProperty) {
        setId(artistProperty.getId());
        setAwardsNumber(artistProperty.getAwardsNumber());
        setDebutYear(artistProperty.getDebutYear());
        setMemberNumber(artistProperty.getMemberNumber());

        return this;
    }

    public ArtistProperty toEntity() {
        ArtistProperty artistProperty = new ArtistProperty();
        artistProperty.setId(getId());
        artistProperty.setAwardsNumber(getAwardsNumber());
        artistProperty.setDebutYear(getDebutYear());
        artistProperty.setMemberNumber(getMemberNumber());

        return artistProperty;
    }
}
