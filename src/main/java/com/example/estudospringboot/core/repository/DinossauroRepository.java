package com.example.estudospringboot.core.repository;

import com.example.estudospringboot.core.model.Dinossauro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DinossauroRepository extends MongoRepository<Dinossauro, String> {
}
