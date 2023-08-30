package com.meefee.main.service.artist;

import com.meefee.main.model.artist.Artist;

public interface ArtistsService {

    Artist findArtistByEmail(String email);
    Artist getCurrentArtist();
    void saveArtist(Artist artist);

}
