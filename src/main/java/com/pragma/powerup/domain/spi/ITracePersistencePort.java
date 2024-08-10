package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Trace;

import java.util.List;

public interface ITracePersistencePort {
    void saveTrace(Trace trace);
    List<Trace> getTracesByIdClientAndIdOrder(Long idClient, Long idOrder);
}
