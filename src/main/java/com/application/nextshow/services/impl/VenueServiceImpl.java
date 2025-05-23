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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VenueServiceImpl implements VenueService {

    private final VenueMapper venueMapper;
    private final VenueRepository venueRepository;

    @Autowired
    public VenueServiceImpl(VenueMapper venueMapper, VenueRepository venueRepository) {
        this.venueMapper = venueMapper;
        this.venueRepository = venueRepository;
    }

    @Override
    public List<VenueDTO> getFilteredVenues(String city, String format) {
        Specification<Venue> spec = VenueSpecification.withFilters(city, format);
        List<Venue> venueList = venueRepository.findAll(spec);
        return venueList.stream()
                .map(venueMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VenueDTO> findVenueById(UUID id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id: " + id));
        VenueDTO venueDTO = venueMapper.toDTO(venue);
        return Optional.of(venueDTO);
    }

    @Override
    public List<VenueDTO> saveAllVenues(List<VenueDTO> venueDTOS) {
        List<Venue> venueList = venueDTOS.stream().map(venueMapper::fromDTO).collect(Collectors.toList());
        venueRepository.saveAll(venueList);
        return venueList.stream().map(venueMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public VenueDTO saveVenue(VenueDTO venueDTO) {

        Venue venue = venueMapper.fromDTO(venueDTO);
        venueRepository.save(venue);
        return venueMapper.toDTO(venue);
    }

    @Override
    public void deleteVenueById(UUID id) {
        venueRepository.deleteById(id);
    }

    @Override
    public Optional<VenueDTO> updateVenue(UUID id, VenueDTO venueDTO) {
        // Retrieve the existing venue by ID
        Optional<Venue> existingVenueOpt = venueRepository.findById(id);

        if (!existingVenueOpt.isPresent()) {
            throw new RuntimeException("Venue not found with id: " + id);
        }


        Venue existingVenue = existingVenueOpt.get();

        // Update the fields that are provided in the DTO
        if (venueDTO.getName() != null) existingVenue.setName(venueDTO.getName());
        if (venueDTO.getDescription() != null) existingVenue.setDescription(venueDTO.getDescription());
        if (venueDTO.getVenueType() != null) existingVenue.setVenueType(venueDTO.getVenueType());
        if (venueDTO.getAddress() != null) existingVenue.setAddress(venueDTO.getAddress());
        if (venueDTO.getCity() != null) existingVenue.setCity(venueDTO.getCity());
        if (venueDTO.getFacilities() != null) existingVenue.setFacilities(venueDTO.getFacilities());
        if (venueDTO.getFormats() != null) existingVenue.setFormats(venueDTO.getFormats());
        if (venueDTO.getScreens() != null) existingVenue.setScreens(venueDTO.getScreens());
        if (venueDTO.getCoordinates() != null) existingVenue.setCoordinates(venueDTO.getCoordinates());
        if (venueDTO.getThumbnail() != null) existingVenue.setThumbnail(venueDTO.getThumbnail());



        venueRepository.save(existingVenue);

        return Optional.of(venueMapper.toDTO(existingVenue));
    }
}
