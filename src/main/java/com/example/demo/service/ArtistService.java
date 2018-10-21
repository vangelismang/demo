package com.example.demo.service;

import com.example.demo.dao.model.Artist;
import com.example.demo.dao.model.ArtistProperty;
import com.example.demo.dao.repository.ArtistRepository;
import com.example.demo.web.dto.ArtistDto;
import com.example.demo.web.mapper.ArtistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    ArtistMapper mapper;

    public ArtistDto createArtist(ArtistDto artistDto) {
        Artist artist = mapper.mapToEntity(artistDto);//artistDto.toEntity();
        ArtistProperty artistProperty = artistDto.getArtistProperty().toEntity();
        artist.setArtistProperty(artistProperty);
        artistProperty.setArtist(artist);

        artist = artistRepository.save(artist);


        return mapper.mapToDto(artist);//new ArtistDto().fromEntity(artist);
    }

    public Artist findById(Long id) {
        return artistRepository.getOne(id);
    }

    public List<ArtistDto> findArtistsByName(String name) {

        return artistRepository.findByName(name)
                .stream()
                .map(artist -> mapper.mapToDto(artist))//new ArtistDto().fromEntity(artist))
                .collect(Collectors.toList());
    }

    public ArtistDto updateArtist(ArtistDto artistDto) {
        artistRepository.findById(artistDto.getId());
        Artist artist = mapper.mapToEntity(artistDto);//artistDto.toEntity();
        artist = artistRepository.save(artist);

        return mapper.mapToDto(artist);//new ArtistDto().fromEntity(artist);
    }

    public void deleteArtist(Long id) {
        Artist artist = artistRepository.getOne(id);

        artistRepository.delete(artist);
    }

    public void deleteArtistProperty(Long id) {
        Artist artist = artistRepository.getOne(id);
        artist.setArtistProperty(null);

        artistRepository.save(artist);
    }
}
