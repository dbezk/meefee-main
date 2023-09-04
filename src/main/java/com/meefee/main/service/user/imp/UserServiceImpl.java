package com.meefee.main.service.user.imp;

import com.meefee.main.dto.FavoriteSingleDTO;
import com.meefee.main.mapper.SingleMapper;
import com.meefee.main.model.artist.ArtistSingle;
import com.meefee.main.model.user.FavoriteSingle;
import com.meefee.main.model.user.Playlist;
import com.meefee.main.model.user.User;
import com.meefee.main.repository.UserRepository;
import com.meefee.main.service.shared.SinglesService;
import com.meefee.main.service.user.PlaylistService;
import com.meefee.main.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PlaylistService playlistService;
    private final SinglesService singlesService;
    private final UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public User getCurrentUser() {
        return userRepository
                .findById(Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName()))
                .orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addPlaylistToUser(Playlist playlist) {
        User user = getCurrentUser();
        user.getPlaylists().add(playlist);
        saveUser(user);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deletePlaylist(Long id) {
        Playlist playlist = playlistService.findPlaylistById(id);
        if(playlist != null) {
            User user = getCurrentUser();
            user.getPlaylists().remove(playlist);
            saveUser(user);
        }
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addFavoriteSingle(Long id) {
        ArtistSingle single = singlesService.getSingleById(id);
        User user = getCurrentUser();
        user.getFavoriteSingles().add(new FavoriteSingle(null, single, user));
        saveUser(user);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void removeFavoriteSingle(Long id) {
        User user = getCurrentUser();
        Collection<FavoriteSingle> favoriteSingles = user.getFavoriteSingles().stream()
                        .filter(favSingle -> !favSingle.getSingle().getId().equals(id)).toList();
        user.setFavoriteSingles(favoriteSingles);
        saveUser(user);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Collection<FavoriteSingleDTO> getFavoriteSingles() {
        User user = getCurrentUser();
        return user.getFavoriteSingles().stream()
                .map(FavoriteSingle::getSingle)
                .map(SingleMapper::mapArtistSingleToFavoriteSingleDTO).toList();
    }


}
