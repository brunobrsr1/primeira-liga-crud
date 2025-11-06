package com.brunobrsr.ligaportugalcrud.repository;

import com.brunobrsr.ligaportugalcrud.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {}
