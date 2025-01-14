package com.application.nextshow.services;

import com.application.nextshow.dtos.ShowDTO;
import com.application.nextshow.entities.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowService {

    List<ShowDTO> findAllShows();
    ShowDTO saveShow(ShowDTO showDTO);
    List<ShowDTO> saveAllShows(List<ShowDTO> showDTOs );



}
