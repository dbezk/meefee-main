package com.meefee.main.service.user.imp;

import com.meefee.main.dto.settings.AccountSettingsDTO;
import com.meefee.main.model.artist.Artist;
import com.meefee.main.model.user.User;
import com.meefee.main.repository.ArtistRepository;
import com.meefee.main.repository.UserRepository;
import com.meefee.main.service.artist.ArtistSettingsService;
import com.meefee.main.service.user.UserSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserSettingsServiceImpl implements UserSettingsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void changeEmail(AccountSettingsDTO accountSettingsDTO) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setEmail(Objects.requireNonNullElse(accountSettingsDTO.getEmail(), user.getEmail()));
        userRepository.save(user);
    }

    @Override
    public void changePersonalData(AccountSettingsDTO accountSettingsDTO) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setFirstName(Objects.requireNonNullElse(accountSettingsDTO.getFirstName(), user.getFirstName()));
        user.setLastName(Objects.requireNonNullElse(accountSettingsDTO.getLastName(), user.getLastName()));
        userRepository.save(user);
    }

    @Override
    public void changePassword(AccountSettingsDTO accountSettingsDTO) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setPassword(passwordEncoder.encode(accountSettingsDTO.getPasswords().getPassword()));
        userRepository.save(user);
    }

}
