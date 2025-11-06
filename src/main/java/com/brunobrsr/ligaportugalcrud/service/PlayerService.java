package com.brunobrsr.ligaportugalcrud.service;

import com.brunobrsr.ligaportugalcrud.model.Player;
import com.brunobrsr.ligaportugalcrud.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void addNewPlayer(Player player) {
        playerRepository.save(player);
    }

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
