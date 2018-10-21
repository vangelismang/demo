package com.example.demo.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Getter
@Setter
public class ArtistDto implements Serializable {

    @Min(1)
    private Long id;

    private String name;

    private Boolean isBand;

    private ArtistPropertyDto artistProperty;
}
