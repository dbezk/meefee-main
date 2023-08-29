package com.meefee.main.controller.shared;

import com.meefee.main.dto.NewAccountDTO;
import com.meefee.main.service.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping(value = "/artist",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerArtist(HttpServletRequest request,
                                            @Valid @RequestBody NewAccountDTO newAccountDTO) {
        registrationService.registerArtist(newAccountDTO);
        URI uri = URI.create(request.getRequestURI());
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(HttpServletRequest request,
                                            @Valid @RequestBody NewAccountDTO newAccountDTO) {
        registrationService.registerUser(newAccountDTO);
        URI uri = URI.create(request.getRequestURI());
        return ResponseEntity.created(uri).build();
    }

}
