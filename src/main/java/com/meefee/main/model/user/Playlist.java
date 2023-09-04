package com.meefee.main.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meefee.main.model.artist.ArtistSingle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<ArtistSingle> singles;

}
