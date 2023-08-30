package com.meefee.main.mapper;

import com.meefee.main.dto.artist.NewSingleDTO;
import com.meefee.main.model.artist.ArtistSingle;

import java.util.Objects;

public class SingleMapper {

    public static ArtistSingle mapNewSingleDtoToArtistSingle(NewSingleDTO newSingleDTO) {
        ArtistSingle artistSingle = new ArtistSingle();
        artistSingle.setTitle(newSingleDTO.getTitle());
        artistSingle.setLyrics(Objects.requireNonNullElse(newSingleDTO.getLyrics(), null));
        return artistSingle;
    }

}
