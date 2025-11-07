package com.brunobrsr.ligaportugalcrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clubName;
    private String city;
    private int yearFounded;
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<Player> players;

    public Club() {}

    public Club(Long id, String clubName, String city, int yearFounded) {
        this.id = id;
        this.clubName = clubName;
        this.city = city;
        this.yearFounded = yearFounded;
    }

    public Long getId() { return id; }
    public String getClubName() { return clubName; }
    public String getCity() { return city; }
    public int getYearFounded() { return yearFounded; }
    public List<Player> getPlayers() { return players; }

    public void setCity(String city) { this.city = city; }
    public void setYearFounded(int yearFounded) { this.yearFounded = yearFounded; }
    public void setClubName(String clubName) { this.clubName = clubName; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Club club)) return false;
        return yearFounded == club.yearFounded && Objects.equals(id, club.id) && Objects.equals(clubName, club.clubName) && Objects.equals(city, club.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clubName, city, yearFounded);
    }
}
