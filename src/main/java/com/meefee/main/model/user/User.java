package com.meefee.main.model.user;

import com.meefee.main.model.Role;
import com.meefee.main.model.artist.ArtistSingle;
import com.meefee.main.model.shared.ListeningStream;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String avatarURL;

    private Long telegramUserID;

    private String firstName;

    private String lastName;

    @Email
    @NotNull
    private String email;

    private String password;

    private boolean isActivated;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Collection<ListeningStream> listeningStreams;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Collection<Playlist> playlists;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Collection<FavoriteSingle> favoriteSingles;

}
