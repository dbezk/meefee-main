package com.meefee.main.controller.artist;

import com.meefee.main.dto.settings.AccountSettingsDTO;
import com.meefee.main.service.artist.ArtistSettingsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/artist/settings")
@RequiredArgsConstructor
public class AccountSettingsController {

    private final ArtistSettingsService artistSettingsService;

    @PatchMapping(value = "/password")
    public ResponseEntity<?> changePassword(@Valid AccountSettingsDTO accountSettingsDTO) {
        artistSettingsService.changePassword(accountSettingsDTO);
        return ResponseEntity.ok().build();
    }

}
