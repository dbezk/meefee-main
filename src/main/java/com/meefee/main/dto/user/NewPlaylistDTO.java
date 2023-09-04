package com.meefee.main.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
public class NewPlaylistDTO {

    @NotNull(message = "Title param is required.")
    @NotEmpty(message = "Invalid title. Title is empty.")
    @Pattern(regexp = "^[a-zA-Z0-9]{2,40}$", message = "Title must contains [2;40] characters and allows only letters and digits.")
    private String title;

}
