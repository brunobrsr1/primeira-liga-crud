package com.brunobrsr.ligaportugalcrud.service;

import com.brunobrsr.ligaportugalcrud.model.Player;
import com.brunobrsr.ligaportugalcrud.repository.PlayerRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional(readOnly = true)
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + id));
    }

    public void updatePlayer(Long id, Player updatedPlayer) {
        Player existingPlayer = getPlayerById(id);
        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setPosition(updatedPlayer.getPosition());
        existingPlayer.setClub(updatedPlayer.getClub());
        playerRepository.save(existingPlayer);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
