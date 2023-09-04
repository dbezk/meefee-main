package com.meefee.main.dto.settings;

import com.meefee.main.annotation.PasswordsMatch;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@PasswordsMatch
public class NewPasswordDTO {

    @NotNull
    @NotEmpty(message = "Invalid current password. Field is empty.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$",
            message = "Invalid password. Password must contains [8;20] characters includes at least one uppercase letter and number.")
    private String currentPassword;

    @NotNull
    @NotEmpty(message = "Invalid new password. Field is empty.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$",
            message = "Invalid password. Password must contains [8;20] characters includes at least one uppercase letter and number.")
    private String newPassword;

    @NotNull
    @NotEmpty(message = "Invalid new retry password. Field is empty.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$",
            message = "Invalid retry password.")
    private String retryNewPassword;

}
