package com.meefee.main.service.artist.imp;

import com.meefee.main.dto.artist.NewSingleDTO;
import com.meefee.main.mapper.SingleMapper;
import com.meefee.main.model.artist.Artist;
import com.meefee.main.model.artist.ArtistSingle;
import com.meefee.main.repository.ArtistSingleRepository;
import com.meefee.main.service.artist.ArtistsService;
import com.meefee.main.service.artist.DiscographyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DiscographyServiceImpl implements DiscographyService {

    private final ArtistsService artistsService;

    private final ArtistSingleRepository artistSingleRepository;

    @Override
    public void createNewSingle(NewSingleDTO newSingleDTO) {
        ArtistSingle artistSingle = SingleMapper.mapNewSingleDtoToArtistSingle(newSingleDTO);
        Artist artist = artistsService.getCurrentArtist();
        artistSingle.setArtist(artist);
        artistSingle.setStreamsAmount(0L);
        artistSingle.setUSI(UUID.randomUUID().toString());
        artistSingle.setReleaseDate(LocalDateTime.now());
        artistSingle.setAlbum(null);
        artistSingle.setListeningStreams(new ArrayList<>());
        artistSingle.setSingleFavoritedCollection(new ArrayList<>());
        artistSingleRepository.save(artistSingle);
    }

    @Override
    public void createNewAlbum(NewSingleDTO newSingleDTO) {

    }

}
