package com.brunobrsr.ligaportugalcrud;

import org.springframework.stereotype.Service;

@Service
public class ClubService {

    private ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public void insertNewClub(Club club) {
        clubRepository.save(club);
    }
}
