package com.pragma.powerup.infrastructure.out.mongodb.adapter;

import com.pragma.powerup.domain.model.Trace;
import com.pragma.powerup.domain.spi.ITracePersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.mongodb.mapper.ITraceEntityMapper;
import com.pragma.powerup.infrastructure.out.mongodb.repository.ITraceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

//@Service
@RequiredArgsConstructor
public class TraceMongodbAdapter implements ITracePersistencePort {
    private final ITraceRepository traceRepository;
    private final ITraceEntityMapper traceEntityMapper;

    //@Autowired
    //private ITraceRepository traceRepository;

    @Override
    public void saveTrace(Trace trace) {
        var a = traceEntityMapper.toEntity(trace);

        traceRepository.save(traceEntityMapper.toEntity(trace));
    }

    @Override
    public List<Trace> getTracesByIdClient(Long idClient) {
        return traceEntityMapper.toTracetList(traceRepository.findAllByIdClient(idClient));
    }

/*

    public List<TraceEntity> obtenerTodasLasPersonas() {
        return traceRepository.findAll();
    }

    public TraceEntity obtenerPersonaPorId(String id) {
        return traceRepository.findById(id).orElse(null);
    }

    public TraceEntity crearPersona(TraceEntity persona) {
        return traceRepository.save(persona);
    }

    public TraceEntity actualizarPersona(String id, TraceEntity persona) {
        if (traceRepository.existsById(id)) {
            persona.setId(id);
            return traceRepository.save(persona);
        }
        return null;
    }

    public void eliminarPersona(String id) {
        traceRepository.deleteById(id);
    }*/


}