package com.example.server.repository;

import com.example.server.model.Camera;
import org.springframework.data.repository.CrudRepository;

public interface CameraRepository extends CrudRepository<Camera, Long> {
}
