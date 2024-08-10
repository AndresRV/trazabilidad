package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Trace;

import java.util.List;

public interface ITraceServicePort {
    void saveTrace(Trace trace);
    List<Trace> getTracesByIdClientAndIdOrder(Long idClient, Long idOrder);
}
