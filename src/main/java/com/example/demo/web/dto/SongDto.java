package com.example.demo.web.dto;

import com.example.demo.dao.model.Song;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SongDto implements Serializable {

    private Long id;

    private String title;

    private Long artistId;

    public SongDto fromEntity(Song song){
        setId(song.getId());
        setTitle(song.getTitle());
        setArtistId(song.getArtist().getId());

        return this;
    }

    public Song toEntity() {
        Song song = new Song();
        song.setId(getId());
        song.setTitle(getTitle());

        return song;
    }

    public void toEntityUpdate(Song song) {
        song.setTitle(getTitle());
    }
}
