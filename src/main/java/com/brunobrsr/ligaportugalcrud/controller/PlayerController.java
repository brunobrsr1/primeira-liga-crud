package com.brunobrsr.ligaportugalcrud.controller;

import com.brunobrsr.ligaportugalcrud.model.Player;
import com.brunobrsr.ligaportugalcrud.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
    @GetMapping("{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PutMapping("{id}")
    public void updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        playerService.updatePlayer(id, updatedPlayer);
    }

    @DeleteMapping("{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
