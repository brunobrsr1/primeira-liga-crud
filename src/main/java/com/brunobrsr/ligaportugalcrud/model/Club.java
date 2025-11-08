package com.brunobrsr.ligaportugalcrud.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String clubName;

    @NotBlank
    private String city;

    @Positive
    private int yearFounded;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Player> players = new ArrayList<>();

    public Long getId() { return id; }
    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public int getYearFounded() { return yearFounded; }
    public void setYearFounded(int yearFounded) { this.yearFounded = yearFounded; }
    public List<Player> getPlayers() { return players; }

    public void addPlayer(Player player) {
        players.add(player);
        player.setClub(this);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        player.setClub(null);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Club club)) return false;
        return yearFounded == club.yearFounded && Objects.equals(id, club.id) && Objects.equals(clubName, club.clubName) && Objects.equals(city, club.city) && Objects.equals(players, club.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clubName, city, yearFounded, players);
    }
}
