package com.meefee.main.dto.settings;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountSettingsDTO {

    @NotEmpty(message = "Email is empty.")
    @Email(message = "Invalid email.")
    private String email;

    @NotEmpty(message = "Invalid first name. Field is empty.")
    @Pattern(regexp = "^[a-zA-Z]{4,15}$",
            message = "First name must contains [4;15] characters and allows only latin alphabet.")
    private String firstName;

    @NotEmpty(message = "Invalid last name. Field is empty.")
    @Pattern(regexp = "^[a-zA-Z]{2,30}$",
            message = "Last name must contains [2;30] characters and allows only latin alphabet.")
    private String lastName;

    @NotEmpty
    private NewPasswordDTO passwords;

}
