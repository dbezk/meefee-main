package com.meefee.main.model.shared;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meefee.main.model.artist.ArtistAlbum;
import com.meefee.main.model.artist.ArtistSingle;
import com.meefee.main.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListeningStream {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private ArtistSingle single;

    @ManyToOne
    @JsonIgnore
    private ArtistAlbum album;

    @ManyToOne
    @JsonIgnore
    private User user;

    private LocalDateTime listenedAt;

}
