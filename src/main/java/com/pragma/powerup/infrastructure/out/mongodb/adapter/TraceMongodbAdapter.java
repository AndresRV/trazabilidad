package com.pragma.powerup.infrastructure.out.mongodb.adapter;

import com.pragma.powerup.infrastructure.out.mongodb.entity.TraceEntity;
import com.pragma.powerup.infrastructure.out.mongodb.repository.ITraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TraceMongodbAdapter {
    @Autowired
    private ITraceRepository traceRepository;

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
    }
}