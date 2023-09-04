package com.meefee.main.dto.artist;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewAlbumDTO {

    @NotNull(message = "Title field required.")
    @NotEmpty(message = "Invalid title. Title is empty.")
    @Pattern(regexp = "^[a-zA-Z0-9-&]{4,50}$",
            message = "Title must contains [4;50] characters and allows only latin alphabet, numbers and -&")
    private String title;

    @NotNull(message = "Singles collection required.")
    @NotEmpty(message = "Invalid album singles. At least 1 single required.")
    private Collection<NewSingleDTO> singles;

}
