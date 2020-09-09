package com.example.server.service;

import com.example.server.model.Tripod;
import com.example.server.repository.TripodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class TripodServiceImpl implements TripodService {
    @Autowired
    TripodRepository tripodRepository;

    @Override
    public Iterable<Tripod> listAllTripods() {
        return tripodRepository.findAll();
    }

    @Override
    public Tripod createTripod(Tripod tripod) {
        return tripodRepository.save(tripod);
    }

    @Override
    public Tripod getTripod(Long id) throws EntityNotFoundException {
        Tripod tripod = null;
        try {
            tripod = tripodRepository.findById(id).get();
        } catch(Exception e) {
            throw new EntityNotFoundException("Tripod not found");
        }
        return tripod;
    }

    @Override
    public HttpStatus deleteTripod(Long id) {
        tripodRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
