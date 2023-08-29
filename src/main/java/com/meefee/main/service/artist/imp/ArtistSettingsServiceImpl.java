package com.meefee.main.service.artist.imp;

import com.meefee.main.dto.settings.AccountSettingsDTO;
import com.meefee.main.model.artist.Artist;
import com.meefee.main.repository.ArtistRepository;
import com.meefee.main.service.artist.ArtistSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistSettingsServiceImpl implements ArtistSettingsService {

    private final ArtistRepository artistRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void changePassword(AccountSettingsDTO accountSettingsDTO) {
        Artist artist = artistRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        artist.setPassword(passwordEncoder.encode(accountSettingsDTO.getPassword()));
        artistRepository.save(artist);
    }

}
