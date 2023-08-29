package com.meefee.main.service;

import com.meefee.main.dto.NewAccountDTO;

public interface RegistrationService {

    void registerArtist(NewAccountDTO newAccountDTO);

    void registerUser(NewAccountDTO newAccountDTO);

}
