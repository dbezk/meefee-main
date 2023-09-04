package com.meefee.main.service.user;

import com.meefee.main.dto.user.NewPlaylistDTO;
import com.meefee.main.dto.PlaylistDTO;
import com.meefee.main.dto.UpdatePlaylistDTO;
import com.meefee.main.model.user.Playlist;

import java.util.Collection;

public interface PlaylistService {
    Playlist findPlaylistById(Long id);
    Collection<PlaylistDTO> getUserPlaylists();
    PlaylistDTO getPlaylistById(Long id);
    void createNewPlaylist(NewPlaylistDTO newPlaylistDTO);
    void addSingleToPlayList(UpdatePlaylistDTO updatePlaylistDTO);
    void removeSingleToPlayList(UpdatePlaylistDTO updatePlaylistDTO);
    void savePlaylist(Playlist playlist);

}
