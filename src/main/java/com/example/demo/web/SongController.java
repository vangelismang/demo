package com.example.demo.web;

import com.example.demo.dao.repository.SongRepository;
import com.example.demo.service.SongService;
import com.example.demo.web.dto.SongDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/song")
public class SongController {

    @Autowired
    SongService songService;

    @Autowired
    SongRepository repository;

    @PostMapping("post")
    public SongDto createSong(@RequestBody SongDto songDto) {
        return songService.createSong(songDto);
    }

    @GetMapping("get/{title}")
    public List<SongDto> getSongs(@PathVariable String title) {
        return songService.findSongsByTitle(title);
    }

    @PutMapping("put/{id}")
    public SongDto putSong(@RequestBody SongDto songDto, @PathVariable Long id) {
        return songService.updateSong(songDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
    }

    @GetMapping
    public List<SongDto> getTest(){
        return repository.findByArtistName("Paradise Lost").stream()
                .map(song -> new SongDto().fromEntity(song))
                .collect(Collectors.toList());
    }
}
