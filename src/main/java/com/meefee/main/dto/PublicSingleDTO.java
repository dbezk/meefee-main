package com.meefee.main.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PublicSingleDTO {

    private Long id;

    private String title;

    private String pictureURL;

    private String lyrics;

    private Long duration;

    private String authorNickname;

    private Long authorId;

    private Long streamsAmount;

    private LocalDateTime releaseDate;

}
