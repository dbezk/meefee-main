package com.meefee.main.service.shared;

import com.meefee.main.dto.register.NewAccountDTO;

public interface RegistrationService {

    void registerArtist(NewAccountDTO newAccountDTO);

    void registerUser(NewAccountDTO newAccountDTO);

}
