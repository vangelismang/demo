package com.example.demo.web.mapper;

import com.example.demo.dao.model.ArtistProperty;
import com.example.demo.web.dto.ArtistPropertyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtistPropertyMapper extends DemoMapper<ArtistProperty, ArtistPropertyDto> {
}
