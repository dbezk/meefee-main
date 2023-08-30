package com.meefee.main.dto.settings;

import com.meefee.main.annotation.PasswordsMatch;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@PasswordsMatch
public class NewPasswordDTO {

    @NotEmpty(message = "Invalid password. Field is empty.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$",
            message = "Invalid password. Password must contains [8;20] characters includes at least one uppercase letter and number.")
    private String password;

    @NotEmpty(message = "Invalid password. Field is empty.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$",
            message = "Invalid password. Password must contains [8;20] characters includes at least one uppercase letter and number.")
    private String retryPassword;

}
