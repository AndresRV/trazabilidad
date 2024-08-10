package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.Utils.Constants;
import com.pragma.powerup.domain.api.ITraceServicePort;
import com.pragma.powerup.domain.model.Trace;
import com.pragma.powerup.domain.spi.ITracePersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
public class TraceUseCase implements ITraceServicePort {
    private final ITracePersistencePort tracePersistencePort;

    @Override
    public void saveTrace(Trace trace) {
        trace.setDateTimeOrder(ZonedDateTime.now(ZoneId.of(Constants.TIME_ZONE)).toLocalDateTime());
        tracePersistencePort.saveTrace(trace);
    }

    @Override
    public List<Trace> getTracesByIdClient(Long idClient) {
        return tracePersistencePort.getTracesByIdClient(idClient);
    }
}
