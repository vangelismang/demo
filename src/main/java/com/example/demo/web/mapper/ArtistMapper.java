package com.example.demo.web.mapper;


import com.example.demo.dao.model.Artist;
import com.example.demo.web.dto.ArtistDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
uses = {
        ArtistPropertyMapper.class
})
public interface ArtistMapper extends DemoMapper<Artist, ArtistDto> {
}
