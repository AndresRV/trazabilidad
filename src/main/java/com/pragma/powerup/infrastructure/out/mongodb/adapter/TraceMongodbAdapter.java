package com.pragma.powerup.infrastructure.out.mongodb.adapter;

import com.pragma.powerup.domain.model.Trace;
import com.pragma.powerup.domain.spi.ITracePersistencePort;
import com.pragma.powerup.infrastructure.out.mongodb.mapper.ITraceEntityMapper;
import com.pragma.powerup.infrastructure.out.mongodb.repository.ITraceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TraceMongodbAdapter implements ITracePersistencePort {
    private final ITraceRepository traceRepository;
    private final ITraceEntityMapper traceEntityMapper;

    @Override
    public void saveTrace(Trace trace) {
        var a = traceEntityMapper.toEntity(trace);

        traceRepository.save(traceEntityMapper.toEntity(trace));
    }

    @Override
    public List<Trace> getTracesByIdClientAndIdOrder(Long idClient, Long idOrder) {
        return traceEntityMapper.toTracetList(traceRepository.findAllByIdClientAndIdOrder(idClient, idOrder));
    }
}