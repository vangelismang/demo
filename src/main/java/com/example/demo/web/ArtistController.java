package com.example.demo.web;

import com.example.demo.service.ArtistService;
import com.example.demo.web.dto.ArtistDto;
import com.example.demo.web.validator.ArtistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/artist")
public class ArtistController {

    @Autowired
    ArtistValidator validator;

    @Autowired
    ArtistService artistService;

    @PostMapping("post")
    public ResponseEntity postArtist(@RequestBody ArtistDto artistDto, BindingResult result) {
        validator.validate(artistDto, result);

        if(result.hasErrors()) {
            return  ResponseEntity.badRequest().body(result.getAllErrors());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(artistService.createArtist(artistDto));
    }

    @GetMapping("get/{name}")
    public List<ArtistDto> getArtists(@PathVariable String name) {
        return artistService.findArtistsByName(name);
    }

    @PutMapping("put/{id}")
    public ResponseEntity putArtist(@RequestBody ArtistDto artistDto, @PathVariable Long id) {
        artistService.updateArtist(artistDto);

        return ResponseEntity.ok().body("It's ok!");
    }

    @DeleteMapping("delete/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtistProperty(id);
    }
}
