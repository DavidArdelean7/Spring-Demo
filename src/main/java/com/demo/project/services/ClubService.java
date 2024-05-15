package com.demo.project.services;

import com.demo.project.dto.ClubDto;
import com.demo.project.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(Long clubId);

    void updateClub(ClubDto clubDto);

    void delete(Long clubId);

    List<ClubDto> searchClubs(String query);
}
