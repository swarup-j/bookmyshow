package com.application.nextshow.controllers;

import com.application.nextshow.dtos.ShowDTO;
import com.application.nextshow.entities.Show;
import com.application.nextshow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ShowController {
    @Autowired
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping(value = "/api/v1/shows")
    public List<ShowDTO> findAllShows(){
        return showService.findAllShows();
    }

    @PostMapping(value = "/api/v1/save-show" )
    public ShowDTO saveShow(@RequestBody ShowDTO showDTO){
        return showService.saveShow(showDTO);
    }
    @PostMapping(value = "/api/v1/save-all-shows")
    public List<ShowDTO> savAllShow(@RequestBody List<ShowDTO> showDTO){
      return showService.saveAllShows(showDTO);
    }
}
