package com.pragma.powerup.infrastructure.out.mongodb.repository;

import com.pragma.powerup.infrastructure.out.mongodb.entity.TraceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITraceRepository extends MongoRepository<TraceEntity, String> {

}
