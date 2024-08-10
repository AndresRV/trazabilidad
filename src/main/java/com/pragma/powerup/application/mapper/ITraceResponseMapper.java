package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.TraceResponse;
import com.pragma.powerup.domain.model.Trace;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITraceResponseMapper {
    List<TraceResponse> toResponseList(List<Trace> traceList);
}
