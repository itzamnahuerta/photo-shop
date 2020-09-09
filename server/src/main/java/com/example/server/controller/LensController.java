package com.example.server.controller;

import com.example.server.model.Lens;
import com.example.server.service.LensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lens")
public class LensController {
    @Autowired
    LensService lensService;

    @GetMapping
    public Iterable<Lens> listAllLenses() {
        return lensService.listAllLenses();
    }

    @PostMapping
    public Lens createLens(@RequestBody Lens lens) {
        return lensService.createLens(lens);
    }

    @GetMapping("/{id}")
    public Lens getLense(@PathVariable Long id) {
        return lensService.getLense(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteLens(@PathVariable Long id) {
        return lensService.deleteLense(id);
    }
}
