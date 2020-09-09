package com.example.server.service;

import com.example.server.model.Camera;
import com.example.server.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CameraServiceImpl implements CameraService {
    @Autowired
    CameraRepository cameraRepository;

    @Override
    public Iterable<Camera> listAllCameras() {
        return cameraRepository.findAll();
    }

    @Override
    public Camera createCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    @Override
    public Camera getCamera(Long id) throws EntityNotFoundException {
        Camera camera = null;
        try {
            camera = cameraRepository.findById(id).get();
        } catch(Exception e) {
            throw new EntityNotFoundException("Camera does no exist");
        }
        return camera;
    }

    @Override
    public HttpStatus deleteCamera(Long id) {
        cameraRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
