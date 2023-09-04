package com.meefee.main.model.artist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArtistAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String pictureURL;

    private Long duration;

    private int singlesAmount;

    private Long streamsAmount;

    private String UAI;

    private LocalDateTime releaseDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "album")
    private Collection<ArtistSingle> singles;

    @ManyToOne
    @JsonIgnore
    private Artist artist;

}
