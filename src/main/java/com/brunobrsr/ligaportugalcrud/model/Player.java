package com.brunobrsr.ligaportugalcrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Objects;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Positive
    private int age;

    @NotBlank
    private String position;

    @Positive
    private int shirtNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    @JsonBackReference
    private Club club;

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public int getShirtNumber() { return shirtNumber; }
    public void setShirtNumber(int shirtNumber) { this.shirtNumber = shirtNumber; }
    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player player)) return false;
        return age == player.age && shirtNumber == player.shirtNumber && Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(position, player.position) && Objects.equals(club, player.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, position, shirtNumber, club);
    }
}
