package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.TraceRequest;
import com.pragma.powerup.application.dto.response.TraceResponse;
import com.pragma.powerup.application.handler.ITraceHandler;
import com.pragma.powerup.application.mapper.ITraceRequestMapper;
import com.pragma.powerup.application.mapper.ITraceResponseMapper;
import com.pragma.powerup.domain.api.ITraceServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TraceHandler implements ITraceHandler {
    private final ITraceServicePort traceServicePort;
    private final ITraceRequestMapper traceRequestMapper;
    private final ITraceResponseMapper traceResponseMapper;

    @Override
    public void saveTrace(TraceRequest traceRequest) {
        traceServicePort.saveTrace(traceRequestMapper.toTrace(traceRequest));
    }

    @Override
    public List<TraceResponse> getTracesByIdClient(Long idClient) {
        return traceResponseMapper.toResponseList(traceServicePort.getTracesByIdClient(idClient));
    }
}
