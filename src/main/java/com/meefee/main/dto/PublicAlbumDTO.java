package com.meefee.main.dto;

import lombok.Data;

@Data
public class PublicAlbumDTO {

    private Long id;

    private String title;

    private String pictureURL;

    private Long duration;

    private String authorNickname;

    private Long streamsAmount;

    private int singlesAmount;

}
