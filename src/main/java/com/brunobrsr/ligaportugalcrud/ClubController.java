package com.brunobrsr.ligaportugalcrud;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clubs")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping
    public void addNewClub(@RequestBody Club club) {
        clubService.insertNewClub(club);
    }

    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @DeleteMapping("{id}")
    public void deleteClub(@PathVariable Long id) {
        clubService.deleteClub(id);
    }
    @GetMapping("{id}")
    public Club getClubById(@PathVariable Long id) {
        return clubService.getClubById(id);
    }
    @PutMapping("{id}")
    public void updateClub(@PathVariable Long id, @RequestBody Club updatedClub) {
        clubService.updateClub(id, updatedClub);
    }
}
