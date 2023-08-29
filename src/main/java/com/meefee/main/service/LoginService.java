package com.meefee.main.service;

import com.meefee.main.model.artist.Artist;
import com.meefee.main.repository.ArtistRepository;
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Artist artist = artistRepository.findByEmail(email);
        if(artist != null) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            artist.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new User(email, artist.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("Person not exist with email :"  + email);
    }
}
