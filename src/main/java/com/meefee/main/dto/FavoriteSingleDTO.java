package com.meefee.main.dto;

import lombok.Data;

@Data
public class FavoriteSingleDTO {

    private Long singleId;

    private String title;

    private String pictureURL;

    private Long duration;

    private String authorNickname;

}
