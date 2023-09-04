package com.meefee.main.service.user;

import com.meefee.main.dto.FavoriteSingleDTO;
import com.meefee.main.model.user.Playlist;
import com.meefee.main.model.user.User;

import java.util.Collection;

public interface UserService {

    User getUserById(Long id);
    User getCurrentUser();
    void saveUser(User user);
    void addPlaylistToUser(Playlist playlist);
    void deletePlaylist(Long id);
    void addFavoriteSingle(Long id);
    void removeFavoriteSingle(Long id);
    Collection<FavoriteSingleDTO> getFavoriteSingles();

}
