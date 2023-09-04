package com.meefee.main.mapper;

import com.meefee.main.dto.FavoriteSingleDTO;
import com.meefee.main.dto.PublicSingleDTO;
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

    public static PublicSingleDTO mapArtistSingleToPublicSingleDTO(ArtistSingle artistSingle) {
        PublicSingleDTO publicSingleDTO = new PublicSingleDTO();
        publicSingleDTO.setId(artistSingle.getId());
        publicSingleDTO.setTitle(artistSingle.getTitle());
        publicSingleDTO.setPictureURL(artistSingle.getPictureURL());
        publicSingleDTO.setLyrics(artistSingle.getLyrics());
        publicSingleDTO.setDuration(artistSingle.getDuration());
        publicSingleDTO.setAuthorNickname(artistSingle.getArtist().getPublisherNickname());
        publicSingleDTO.setAuthorId(artistSingle.getArtist().getId());
        publicSingleDTO.setStreamsAmount(artistSingle.getStreamsAmount());
        publicSingleDTO.setReleaseDate(artistSingle.getReleaseDate());
        return publicSingleDTO;
    }

    public static FavoriteSingleDTO mapArtistSingleToFavoriteSingleDTO(ArtistSingle artistSingle) {
        FavoriteSingleDTO favoriteSingleDTO = new FavoriteSingleDTO();
        favoriteSingleDTO.setSingleId(artistSingle.getId());
        favoriteSingleDTO.setTitle(artistSingle.getTitle());
        favoriteSingleDTO.setPictureURL(artistSingle.getPictureURL());
        favoriteSingleDTO.setDuration(artistSingle.getDuration());
        favoriteSingleDTO.setAuthorNickname(artistSingle.getArtist().getPublisherNickname());
        return favoriteSingleDTO;
    }

}
