package com.example.demo.web.validator;

import com.example.demo.web.dto.ArtistDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class ArtistValidator {

    public void validate(ArtistDto dto, BindingResult result) {

        if(dto.getName().equals("hello")){
//            throw new IllegalArgumentException("Name must not be null!");
            result.rejectValue("name", "hello", "name must not be hello");
        }

        if(dto.getArtistProperty() == null){
            result.rejectValue("artistPropertyDto", "artistProperty", "artistPropertyDto not be null");
        }
    }
}
