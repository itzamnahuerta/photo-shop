package com.example.server.service;

import com.example.server.model.Tripod;
import org.springframework.http.HttpStatus;

public interface TripodService {
    Iterable<Tripod> listAllTripods();
    Tripod createTripod(Tripod tripod);
    Tripod getTripod(Long id);
    HttpStatus deleteTripod(Long id);
}
