package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.TraceRequest;
import com.pragma.powerup.application.dto.response.TraceResponse;

import java.util.List;

public interface ITraceHandler {
    void saveTrace(TraceRequest traceRequest);
    List<TraceResponse> getTracesByIdClientAndIdOrder(Long idClient, Long idOrder);
}
