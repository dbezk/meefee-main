package com.meefee.main.controller.user;

import com.meefee.main.dto.user.NewPlaylistDTO;
import com.meefee.main.dto.PlaylistDTO;
import com.meefee.main.dto.UpdatePlaylistDTO;
import com.meefee.main.service.user.PlaylistService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user/playlist")
@RequiredArgsConstructor
public class PlaylistsController {

    private final PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<PlaylistDTO>> getUserPlaylists() {
        return ResponseEntity.ok(playlistService.getUserPlaylists().stream().toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlaylistDTO> getPlaylistById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @PostMapping
    public ResponseEntity<?> createNewPlaylist(HttpServletRequest request,
                                               @Valid @RequestBody NewPlaylistDTO newPlaylistDTO) {
        playlistService.createNewPlaylist(newPlaylistDTO);
        URI uri = URI.create(request.getRequestURI());
        return ResponseEntity.created(uri).build();
    }

    @PatchMapping(value = "/addSingle")
    public ResponseEntity<?> addSingleToPlayList(@RequestBody UpdatePlaylistDTO updatePlaylistDTO) {
        playlistService.addSingleToPlayList(updatePlaylistDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/removeSingle")
    public ResponseEntity<?> removeSingleToPlayList(@RequestBody UpdatePlaylistDTO updatePlaylistDTO) {
        playlistService.removeSingleToPlayList(updatePlaylistDTO);
        return ResponseEntity.ok().build();
    }

}
