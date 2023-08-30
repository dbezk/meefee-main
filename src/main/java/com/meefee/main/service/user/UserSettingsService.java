package com.meefee.main.service.user;

import com.meefee.main.dto.settings.AccountSettingsDTO;

public interface UserSettingsService {

    void changeEmail(AccountSettingsDTO accountSettingsDTO);
    void changePersonalData(AccountSettingsDTO accountSettingsDTO);
    void changePassword(AccountSettingsDTO accountSettingsDTO);

}
