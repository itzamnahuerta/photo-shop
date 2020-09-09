package com.example.server.service;

import com.example.server.model.Lens;
import org.springframework.http.HttpStatus;

public interface LensService {
    Iterable<Lens> listAllLenses();
    Lens createLens(Lens lens);
    Lens getLense(Long id);
    HttpStatus deleteLense(Long id);
}
