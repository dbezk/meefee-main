package com.meefee.main.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
public class PlaylistDTO {

    private Long id;

    private String title;

    private LocalDateTime createdAt;

    private Integer singlesAmount;

    private Collection<PublicSingleDTO> singles;

}
