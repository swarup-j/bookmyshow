package com.application.nextshow.services.impl;

import com.application.nextshow.dtos.VenueDTO;
import com.application.nextshow.entities.Venue;
import com.application.nextshow.mappers.VenueMapper;
import com.application.nextshow.repositories.VenueRepository;
import com.application.nextshow.services.VenueService;
import com.application.nextshow.specifications.VenueSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private final VenueMapper venueMapper;

    @Autowired
    private final VenueRepository venueRepository;
    public VenueServiceImpl(VenueMapper venueMapper, VenueRepository venueRepository) {
        this.venueMapper = venueMapper;
        this.venueRepository = venueRepository;
    }

    @Override
    public List<VenueDTO> getFilteredVenues(String city, String[] formats){
        Specification<Venue> spec = VenueSpecification.withFilters(city, formats);
        List<Venue> venueList = venueRepository.findAll(spec);
        return venueList.stream().
                map(venueMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<VenueDTO> findVenueById(UUID id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        VenueDTO venueDTO = venueMapper.toDTO(venue);
        return Optional.of(venueDTO);

    }

    @Override
    public List<VenueDTO> saveAllVenues(List<VenueDTO> venueDTOS) {
        List<Venue> venueList = venueDTOS.stream().map(venueMapper::fromDTO).collect(Collectors.toList());
        venueRepository.saveAll(venueList);
        venueRepository.findAll();
        return  venueList.stream().map(venueMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public VenueDTO saveVenue(VenueDTO venueDTO) {
        Venue venue  = venueMapper.fromDTO(venueDTO);
        log.info("saving");
        venueRepository.save(venue);
        log.info("saved");
        return venueMapper.toDTO( venueMapper.fromDTO(venueDTO));
    }


    @Override
    public void deleteVenueById(UUID id) {
        venueRepository.deleteById(id);


    }
}
