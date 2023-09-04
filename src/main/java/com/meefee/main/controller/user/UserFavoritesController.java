package com.meefee.main.controller.user;

import com.meefee.main.service.user.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user/favorites")
@RequiredArgsConstructor
public class UserFavoritesController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUserFavoriteSingles() {
        return ResponseEntity.ok(userService.getFavoriteSingles());
    }

}
