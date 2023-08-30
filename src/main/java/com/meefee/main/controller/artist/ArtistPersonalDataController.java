package com.meefee.main.controller.artist;

import com.meefee.main.model.artist.Artist;
import com.meefee.main.service.artist.ArtistsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/artist/personal")
@RequiredArgsConstructor
public class ArtistPersonalDataController {

    private final ArtistsService artistsService;

    @GetMapping
    public ResponseEntity<Artist> getFullPersonalData() {
        Artist artist = artistsService.getCurrentArtist();
        return ResponseEntity.ok(artist);
    }

}
