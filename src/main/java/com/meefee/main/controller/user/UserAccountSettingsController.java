package com.meefee.main.controller.user;

import com.meefee.main.dto.settings.AccountSettingsDTO;
import com.meefee.main.service.user.UserSettingsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user/settings")
@RequiredArgsConstructor
public class UserAccountSettingsController {

    private final UserSettingsService userSettingsService;

    @PatchMapping(value = "/changeEmail")
    public ResponseEntity<?> changeEmail(@Valid AccountSettingsDTO accountSettingsDTO) {
        userSettingsService.changeEmail(accountSettingsDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/changePersonalData")
    public ResponseEntity<?> changePersonalData(@Valid AccountSettingsDTO accountSettingsDTO) {
        userSettingsService.changePersonalData(accountSettingsDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/changePassword")
    public ResponseEntity<?> changePassword(@Valid AccountSettingsDTO accountSettingsDTO) {
        userSettingsService.changePassword(accountSettingsDTO);
        return ResponseEntity.ok().build();
    }

}
