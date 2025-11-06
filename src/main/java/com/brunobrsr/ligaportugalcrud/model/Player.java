package com.brunobrsr.ligaportugalcrud.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String position;
    private int shirtNumber;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "club_id")
    private Club club;

    public Player() {}

    public Player(Long id, String name, int age, String position, int shirtNumber, Club club) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player player)) return false;
        return age == player.age && shirtNumber == player.shirtNumber && Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, position, shirtNumber);
    }
}
