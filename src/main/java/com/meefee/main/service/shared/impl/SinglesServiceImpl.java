package com.meefee.main.service.shared.impl;

import com.meefee.main.model.artist.ArtistSingle;
import com.meefee.main.repository.ArtistSingleRepository;
import com.meefee.main.service.shared.SinglesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SinglesServiceImpl implements SinglesService {

    private final ArtistSingleRepository artistSingleRepository;

    @Override
    public ArtistSingle findSingleByUSI(String USI) {
        return null;
    }
}
