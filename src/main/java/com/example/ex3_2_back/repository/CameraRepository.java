package com.example.ex3_2_back.repository;


import com.example.ex3_2_back.entity.Camera;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera,Integer> {
    Page<Camera> findByRemoveIsFalse(Pageable pageable);
}
