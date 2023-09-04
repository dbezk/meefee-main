package com.meefee.main.service.user.imp;

import com.meefee.main.dto.user.NewPlaylistDTO;
import com.meefee.main.dto.PlaylistDTO;
import com.meefee.main.dto.UpdatePlaylistDTO;
import com.meefee.main.mapper.PlaylistMapper;
import com.meefee.main.model.artist.ArtistSingle;
import com.meefee.main.model.user.Playlist;
import com.meefee.main.repository.PlaylistRepository;
import com.meefee.main.service.shared.SinglesService;
import com.meefee.main.service.user.PlaylistService;
import com.meefee.main.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final UserService userService;
    private final PlaylistRepository playlistRepository;
    private final SinglesService singlesService;


    @Override
    public Playlist findPlaylistById(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Collection<PlaylistDTO> getUserPlaylists() {
        Collection<Playlist> playlists = userService.getCurrentUser().getPlaylists();
        return playlists.stream().map(playlist -> PlaylistMapper.mapPlaylistToPlaylistDTO(playlist, true)).toList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public PlaylistDTO getPlaylistById(Long id) {
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if(playlist != null) {
            return PlaylistMapper.mapPlaylistToPlaylistDTO(playlist, false);
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void createNewPlaylist(NewPlaylistDTO newPlaylistDTO) {
        Playlist playlist = PlaylistMapper.mapNewPlaylistDtoToPLaylist(newPlaylistDTO);
        savePlaylist(playlist);
        userService.addPlaylistToUser(playlist);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addSingleToPlayList(UpdatePlaylistDTO updatePlaylistDTO) {
        ArtistSingle single = singlesService.getSingleById(updatePlaylistDTO.getSingleId());
        Playlist playlist = playlistRepository.findById(updatePlaylistDTO.getPlaylistId()).orElse(null);
        if(single != null && playlist != null) {
            playlist.getSingles().add(single);
            savePlaylist(playlist);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void removeSingleToPlayList(UpdatePlaylistDTO updatePlaylistDTO) {
        ArtistSingle single = singlesService.getSingleById(updatePlaylistDTO.getSingleId());
        Playlist playlist = playlistRepository.findById(updatePlaylistDTO.getPlaylistId()).orElse(null);
        if(single != null && playlist != null) {
            playlist.getSingles().remove(single);
            savePlaylist(playlist);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void savePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

}
