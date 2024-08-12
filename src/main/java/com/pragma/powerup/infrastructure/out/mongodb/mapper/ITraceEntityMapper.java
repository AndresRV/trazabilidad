package com.pragma.powerup.infrastructure.out.mongodb.mapper;

import com.pragma.powerup.domain.model.Trace;
import com.pragma.powerup.infrastructure.out.mongodb.entity.TraceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITraceEntityMapper {
    TraceEntity toEntity(Trace trace);
    List<Trace> toTracetList(List<TraceEntity> traceEntityList);
}
