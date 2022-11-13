package com.example.estudospringboot.service;

import com.example.estudospringboot.core.dto.DinossauroDTO;
import com.example.estudospringboot.core.model.Dinossauro;
import org.springframework.cloud.sleuth.annotation.NewSpan;

import java.util.List;
import java.util.Optional;

public interface DinossauroService {

    @NewSpan
    List<Dinossauro> findAll();

    @NewSpan
    Optional<Dinossauro> findById(String id);

    @NewSpan
    Optional<Dinossauro> update(String id, DinossauroDTO dinossauroDTO);

    @NewSpan
    Dinossauro insert(DinossauroDTO dinossauroDTO);

    @NewSpan
    void deleteById(String id);
}
