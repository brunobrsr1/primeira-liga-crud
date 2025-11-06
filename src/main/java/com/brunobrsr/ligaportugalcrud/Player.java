package com.brunobrsr.ligaportugalcrud;

import java.util.Objects;

public class Player {
    private String name;
    private int age;
    private String position;
    private int shirtNumber;

    public Player(String name, int age, String position, int shirtNumber) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.shirtNumber = shirtNumber;
    }

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
