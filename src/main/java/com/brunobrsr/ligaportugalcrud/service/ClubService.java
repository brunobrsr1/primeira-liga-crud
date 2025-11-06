package com.brunobrsr.ligaportugalcrud.service;

import com.brunobrsr.ligaportugalcrud.model.Club;
import com.brunobrsr.ligaportugalcrud.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public void insertNewClub(Club club) {
        clubRepository.save(club);
    }

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }

    public Club getClubById(Long id) {
        return clubRepository.findById(id).orElseThrow(() -> new IllegalStateException("Club with id " + id + " does not exist."));
    }

    public void updateClub(Long id, Club updatedClub) {
        Club existingClub = clubRepository.findById(id).orElseThrow(() -> new IllegalStateException("Club with id " + id + " does not exist."));

        if (updatedClub.getClubName() != null) {
            existingClub.setClubName(updatedClub.getClubName());
        }
        if(updatedClub.getCity() != null) {
            existingClub.setCity(updatedClub.getCity());
        }
        if(updatedClub.getYearFounded() > 0) {
            existingClub.setYearFounded(updatedClub.getYearFounded());
        }

        clubRepository.save(existingClub);
    }
}
