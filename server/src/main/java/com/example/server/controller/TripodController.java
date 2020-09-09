package com.example.server.controller;

import com.example.server.model.Tripod;
import com.example.server.service.TripodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tripod")
public class TripodController {
    @Autowired
    TripodService tripodService;

    @GetMapping
    public Iterable<Tripod> listAllTripods() {
        return tripodService.listAllTripods();
    }

    @PostMapping
    public Tripod createTripod(@RequestBody Tripod tripod) {
        return tripodService.createTripod(tripod);
    }

    @GetMapping("/{id}")
    public Tripod getTripod(@PathVariable Long id) {
        return tripodService.getTripod(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTripod(@PathVariable Long id) {
        return tripodService.deleteTripod(id);
    }
}
