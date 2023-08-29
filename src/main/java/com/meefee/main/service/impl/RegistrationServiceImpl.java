package com.meefee.main.service.impl;

import com.meefee.main.constants.Roles;
import com.meefee.main.dto.NewAccountDTO;
import com.meefee.main.mapper.RegistrationMapper;
import com.meefee.main.model.Role;
import com.meefee.main.model.artist.Artist;
import com.meefee.main.model.user.User;
import com.meefee.main.repository.ArtistRepository;
import com.meefee.main.repository.RoleRepository;
import com.meefee.main.repository.UserRepository;
import com.meefee.main.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerArtist(NewAccountDTO newAccountDTO) {
        Role artistRole = roleRepository.findByName(Roles.ARTIST_ROLE);
        Artist artist = RegistrationMapper.mapToArtist(newAccountDTO);
        artist.setPassword(passwordEncoder.encode(artist.getPassword()));
        artist.setRoles(Collections.singletonList(artistRole));
        artist.setActivated(false);
        artist.setVerified(false);
        artist.setSingles(new ArrayList<>());
        artist.setAlbums(new ArrayList<>());
        artistRepository.save(artist);
    }

    @Override
    public void registerUser(NewAccountDTO newAccountDTO) {
        Role userRole = roleRepository.findByName(Roles.USER_ROLE);
        User user = RegistrationMapper.mapToUser(newAccountDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList(userRole));
        user.setActivated(false);
        user.setListeningStreams(new ArrayList<>());
        user.setPlaylists(new ArrayList<>());
        user.setFavoriteSingles(new ArrayList<>());
        user.setFavoriteAlbums(new ArrayList<>());
        userRepository.save(user);
    }
}
