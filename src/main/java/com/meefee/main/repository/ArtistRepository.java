package com.meefee.main.repository;

import com.meefee.main.model.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Artist findByEmail(String email);

}
