package com.pragma.powerup.infrastructure.out.mongodb.repository;

import com.pragma.powerup.infrastructure.out.mongodb.entity.TraceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITraceRepository extends MongoRepository<TraceEntity, String> {
    List<TraceEntity> findAllByIdClient(Long idClient);
}
