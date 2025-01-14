package com.application.nextshow.controllers;

import com.application.nextshow.dtos.ShowDTO;
import com.application.nextshow.entities.Show;
import com.application.nextshow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shows")

public class ShowController {
    @Autowired
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<ShowDTO> findAllShows(){
        return showService.findAllShows();
    }
    @GetMapping("/id")
    public ShowDTO findShowById(@PathVariable UUID id){
        return showService.findShowById(id);
    }
    @PostMapping
    public ShowDTO saveShow(@RequestBody ShowDTO showDTO){
        return showService.saveShow(showDTO);
    }
    @PostMapping("/bulk")
    public List<ShowDTO> savAllShow(@RequestBody List<ShowDTO> showDTO){
      return showService.saveAllShows(showDTO);
    }
    @DeleteMapping("/id")
    public void deleteShowById(@PathVariable UUID id){
        showService.deleteShowById(id);
    }
}
