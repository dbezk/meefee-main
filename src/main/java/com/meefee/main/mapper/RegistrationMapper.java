package com.meefee.main.mapper;

import com.meefee.main.dto.register.NewAccountDTO;
import com.meefee.main.model.artist.Artist;
import com.meefee.main.model.user.User;

public class RegistrationMapper {

    public static Artist mapDtoToArtist(NewAccountDTO newAccountDTO) {
        Artist artist = new Artist();
        artist.setEmail(newAccountDTO.getEmail());
        artist.setPassword(newAccountDTO.getPassword());
        return artist;
    }

    public static User mapDtoToUser(NewAccountDTO newAccountDTO) {
        User user = new User();
        user.setEmail(newAccountDTO.getEmail());
        user.setPassword(newAccountDTO.getPassword());
        return user;
    }

}
