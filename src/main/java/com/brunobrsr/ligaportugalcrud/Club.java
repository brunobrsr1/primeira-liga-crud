package com.brunobrsr.ligaportugalcrud;

import java.util.Objects;

public class Club {
    private String clubName;
    private String city;
    private int yearFounded;

    public Club(String clubName, String city, int yearFounded) {
        this.clubName = clubName;
        this.city = city;
        this.yearFounded = yearFounded;
    }

    public String getClubName() { return clubName; }
    public String getCity() { return city; }
    public int getYearFounded() { return yearFounded; }

    public void setCity(String city) { this.city = city; }
    public void setYearFounded(int yearFounded) { this.yearFounded = yearFounded; }
    public void setClubName(String clubName) { this.clubName = clubName; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Club club)) return false;
        return yearFounded == club.yearFounded && Objects.equals(clubName, club.clubName) && Objects.equals(city, club.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, city, yearFounded);
    }
}
