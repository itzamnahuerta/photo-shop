package com.example.server.service;

import com.example.server.model.Camera;
import org.springframework.http.HttpStatus;

public interface CameraService {
    Iterable<Camera> listAllCameras();
    Camera createCamera(Camera camera);
    Camera getCamera(Long id);
    HttpStatus deleteCamera(Long id);
}
