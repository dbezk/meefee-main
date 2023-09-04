package com.meefee.main.mapper;

import com.meefee.main.dto.user.NewPlaylistDTO;
import com.meefee.main.dto.PlaylistDTO;
import com.meefee.main.model.user.Playlist;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PlaylistMapper {

    public static Playlist mapNewPlaylistDtoToPLaylist(NewPlaylistDTO newPlaylistDTO) {
        Playlist playlist = new Playlist();
        playlist.setTitle(newPlaylistDTO.getTitle());
        playlist.setCreatedAt(LocalDateTime.now());
        playlist.setSingles(new ArrayList<>());
        return playlist;
    }

    public static PlaylistDTO mapPlaylistToPlaylistDTO(Playlist playlist, boolean emptySingles) {
        PlaylistDTO newPlaylistDTO = new PlaylistDTO();
        newPlaylistDTO.setId(playlist.getId());
        newPlaylistDTO.setTitle(playlist.getTitle());
        newPlaylistDTO.setCreatedAt(playlist.getCreatedAt());
        newPlaylistDTO.setSingles(new ArrayList<>());
        newPlaylistDTO.setSinglesAmount(playlist.getSingles().size());
        if(!emptySingles) {
            newPlaylistDTO.setSingles(playlist.getSingles().stream().map(SingleMapper::mapArtistSingleToPublicSingleDTO).toList());
        }
        return newPlaylistDTO;
    }

}
