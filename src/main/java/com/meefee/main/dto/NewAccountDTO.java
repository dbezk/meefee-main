package com.meefee.main.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewAccountDTO {

    @NotNull(message = "Email field not exists.")
    @NotEmpty(message = "Email is empty.")
    @Email(message = "Invalid email.")
    private String email;

    @NotNull(message = "Password field not exists.")
    @NotEmpty(message = "Password is empty.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$",
            message = "Password must contains [8;20] characters includes at least one uppercase letter and number.")
    private String password;

}
