package com.meefee.main.model.artist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meefee.main.model.shared.ListeningStream;
import com.meefee.main.model.user.FavoriteSingle;
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
public class ArtistSingle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String pictureURL;

    private Long duration;

    private Long streamsAmount;

    @Column(length = 2000)
    private String lyrics;

    private String USI;

    private LocalDateTime releaseDate;

    @ManyToOne
    @JsonIgnore
    private Artist artist;

    @ManyToOne
    @JsonIgnore
    private ArtistAlbum album;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "single")
    @JsonIgnore
    private Collection<ListeningStream> listeningStreams;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "single")
    @JsonIgnore
    private Collection<FavoriteSingle> singleFavoritedCollection;

}
