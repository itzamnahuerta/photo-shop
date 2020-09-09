package com.example.server.service;

import com.example.server.model.Lens;
import com.example.server.repository.LensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LensServiceImpl implements LensService {
    @Autowired
    LensRepository lensRepository;

    @Override
    public Iterable<Lens> listAllLenses() {
        return lensRepository.findAll();
    }

    @Override
    public Lens createLens(Lens lens) {
        return lensRepository.save(lens);
    }

    @Override
    public Lens getLense(Long id) throws EntityNotFoundException {
        Lens lens = null;
        try {
            lens = lensRepository.findById(id).get();
        } catch(Exception e) {
            throw new EntityNotFoundException("Lens not found");
        }
        return lens;
    }

    @Override
    public HttpStatus deleteLense(Long id) {
        lensRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
