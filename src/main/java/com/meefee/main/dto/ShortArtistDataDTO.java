package com.meefee.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShortArtistDataDTO {

    private Long id;

    private String artistNickname;

    private String avatarURL;

    private boolean isVerified;

}
