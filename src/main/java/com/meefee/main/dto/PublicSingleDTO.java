package com.meefee.main.dto;

import lombok.Data;

@Data
public class PublicSingleDTO {

    private Long id;

    private String title;

    private String pictureURL;

    private Long duration;

    private String authorNickname;

    private Long streamsAmount;

}
