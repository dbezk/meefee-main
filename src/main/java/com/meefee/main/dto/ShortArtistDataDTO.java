package com.meefee.main.dto;

import lombok.*;

@Data
public class ShortArtistDataDTO {

    private Long id;

    private String artistNickname;

    private String avatarURL;

    private boolean isVerified;

}
