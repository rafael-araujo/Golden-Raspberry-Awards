package com.example.demo.controller;

import com.example.demo.model.dto.AwardIntervalDTO;
import com.example.demo.service.MovieAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie-awards")
public class MovieAwardController {

    @Autowired
    private MovieAwardService service;

    @GetMapping("/intervals")
    public ResponseEntity<AwardIntervalDTO> getIntervals() {
        AwardIntervalDTO intervals = service.calculateAwardIntervals();
        return ResponseEntity.ok(intervals);
    }
}