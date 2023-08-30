package com.meefee.main.controller.artist;

import com.meefee.main.dto.artist.NewSingleDTO;
import com.meefee.main.service.artist.DiscographyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/artist/discography")
@RequiredArgsConstructor
public class DiscographyController {

    private final DiscographyService discographyService;

    @PostMapping(value = "/newSingle")
    public ResponseEntity<?> createNewSingle(HttpServletRequest request,
                                            @Valid @RequestBody NewSingleDTO newSingleDTO) {
        discographyService.createNewSingle(newSingleDTO);
        URI uri = URI.create(request.getRequestURI());
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/newAlbum")
    public ResponseEntity<?> createNewAlbum(HttpServletRequest request,
                                             @Valid @RequestBody NewSingleDTO newSingleDTO) {
        discographyService.createNewSingle(newSingleDTO);
        URI uri = URI.create(request.getRequestURI());
        return ResponseEntity.created(uri).build();
    }

}
