package com.demo.project.services.impl;

import com.demo.project.dto.ClubDto;
import com.demo.project.models.Club;
import com.demo.project.repository.ClubRepository;
import com.demo.project.services.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClub(query);
        return  clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private Club mapToClub(ClubDto clubDto) {

        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .content(clubDto.getContent())
                .photoUrl(clubDto.getPhotoUrl())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();

        return club;
    }
}
