package com.example.demo.service;

import com.example.demo.dao.model.Artist;
import com.example.demo.dao.model.QSong;
import com.example.demo.dao.model.Song;
import com.example.demo.dao.repository.SongRepository;
import com.example.demo.web.dto.SongDto;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    private QSong qSong = QSong.song;

    @Autowired
    SongRepository songRepository;

    @Autowired
    ArtistService artistService;

    public SongDto createSong(SongDto songDto) {
        Song song = songDto.toEntity();
        Artist artist = artistService.findById(songDto.getArtistId());
        song.setArtist(artist);
        song = songRepository.save(song);

        return new SongDto().fromEntity(song);
    }

    public List<SongDto> findSongsByTitle(String title) {

        return songRepository.findByTitleLike(title)
                .stream()
                .map(song -> new SongDto().fromEntity(song))
                .collect(Collectors.toList());
    }

    public SongDto updateSong(SongDto songDto) {
        Song song = songDto.toEntity();

        Artist artist = artistService.findById(songDto.getArtistId());
        song.setArtist(artist);
        song = songRepository.save(song);

        return new SongDto().fromEntity(song);
    }

    public void deleteSong(Long id) {
        Song song = songRepository.getOne(id);
        songRepository.delete(song);
    }

    public Song hello() {
        List<String> myList = new ArrayList<>();
        myList.add("title");
        Predicate predicate = qSong.title.eq("hahahahahahha")
                .and(qSong.artist.name.eq("hohoho"))
                .and(qSong.artist.artistProperty.debutYear.gt("1990"))
                .and(qSong.title.in(myList));

        return songRepository.findOne(predicate).orElseThrow(
                ()-> new RuntimeException()
        );

//        songRepository.findAll(predicate, Sort.by(Sort.Direction.ASC, "title"));
    }
}
