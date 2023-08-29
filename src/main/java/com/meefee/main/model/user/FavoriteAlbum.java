package com.meefee.main.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meefee.main.model.artist.ArtistAlbum;
import com.meefee.main.model.artist.ArtistSingle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoriteAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private ArtistAlbum album;

    @ManyToOne
    @JsonIgnore
    private User user;

}
