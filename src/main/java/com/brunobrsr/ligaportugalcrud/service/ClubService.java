package com.brunobrsr.ligaportugalcrud.service;

import com.brunobrsr.ligaportugalcrud.model.Club;
import com.brunobrsr.ligaportugalcrud.model.Player;
import com.brunobrsr.ligaportugalcrud.repository.ClubRepository;
import com.brunobrsr.ligaportugalcrud.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository, PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
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

    public List<Player> getPlayersByClubId(Long clubId) {
        Club club = getClubById(clubId);
        return club.getPlayers();
    }

    public void insertNewPlayer(Long clubId, Player player) {
        Club club = getClubById(clubId);
        player.setClub(club);
        playerRepository.save(player);
    }
}
