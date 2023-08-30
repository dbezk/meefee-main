package com.meefee.main.service.artist.imp;

import com.meefee.main.model.artist.Artist;
import com.meefee.main.repository.ArtistRepository;
import com.meefee.main.service.artist.ArtistsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistsServiceImpl implements ArtistsService {

    private final ArtistRepository artistRepository;

    @Override
    public Artist findArtistByEmail(String email) {
        return artistRepository.findByEmail(email);
    }

    @Override
    public Artist getCurrentArtist() {
        return artistRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public void saveArtist(Artist artist) {
        artistRepository.save(artist);
    }

}
