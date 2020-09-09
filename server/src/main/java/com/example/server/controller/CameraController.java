package com.example.server.controller;

import com.example.server.model.Camera;
import com.example.server.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/camera")
public class CameraController {
    @Autowired
    CameraService cameraService;

    @GetMapping
    public Iterable<Camera> listAllCameras() {
        return cameraService.listAllCameras();
    }

    @PostMapping
    public Camera createCamera(@RequestBody Camera camera) {
        return cameraService.createCamera(camera);
    }

    @GetMapping("/{id}")
    public Camera getCamera(@PathVariable Long id) {
        return cameraService.getCamera(id);
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteCamera(@PathVariable Long id) {
        return cameraService.deleteCamera(id);
    }
}
