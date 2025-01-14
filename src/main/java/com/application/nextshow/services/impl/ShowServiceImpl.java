package com.application.nextshow.services.impl;

import com.application.nextshow.dtos.FoodDTO;
import com.application.nextshow.dtos.ShowDTO;
import com.application.nextshow.entities.Food;
import com.application.nextshow.entities.Show;
import com.application.nextshow.entities.enums.FoodType;
import com.application.nextshow.mappers.ShowMapper;
import com.application.nextshow.repositories.ShowRepository;
import com.application.nextshow.services.ShowService;
import com.application.nextshow.specifications.FoodSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private final ShowRepository showRepository;

    @Autowired
    private final ShowMapper showMapper;

    public ShowServiceImpl(ShowRepository showRepository, ShowMapper showMapper) {
        this.showRepository = showRepository;
        this.showMapper = showMapper;
    }

    @Override
    public List<ShowDTO> findAllShows() {
        List<Show> shows = showRepository.findAll();
        return shows.stream().
                map(showMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShowDTO saveShow(ShowDTO showDTO) {
        Show show = showMapper.fromDTO(showDTO);
         showRepository.save(show);
         return showMapper.toDTO(show);
    }

    @Override
    public List<ShowDTO> saveAllShows(List<ShowDTO> showDTOs ) {
        List<Show> shows = showDTOs.stream().map(showMapper::fromDTO).collect(Collectors.toList());
        showRepository.saveAll(shows);
        return showDTOs;
    }


}
