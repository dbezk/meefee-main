package com.meefee.main.repository;

import com.meefee.main.model.artist.ArtistSingle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistSingleRepository extends JpaRepository<ArtistSingle, Long> {
}
