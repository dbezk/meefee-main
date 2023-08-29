package com.meefee.main.model.artist;

import com.meefee.main.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String avatarURL;

    private Long telegramUserID;

    private String firstName;

    private String lastName;

    private String publisherNickname;

    @Email
    private String email;

    private String password;

    private String phoneNumber;

    private String address;

    @URL
    private String instagramLink;

    private boolean isActivated;

    private boolean isVerified;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "artist")
    private Collection<ArtistSingle> singles;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "artist")
    private Collection<ArtistAlbum> albums;

}
