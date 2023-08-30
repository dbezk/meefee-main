package com.meefee.main.service.shared.impl;

import com.meefee.main.model.artist.Artist;
import com.meefee.main.repository.ArtistRepository;
import com.meefee.main.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Artist artist = artistRepository.findByEmail(email);
        com.meefee.main.model.user.User user = userRepository.findByEmail(email);
        if(user != null) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new User(email, user.getPassword(), authorities);
        } else if(artist != null) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            artist.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new User(email, artist.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("Person not exist with email :"  + email);
    }
}
