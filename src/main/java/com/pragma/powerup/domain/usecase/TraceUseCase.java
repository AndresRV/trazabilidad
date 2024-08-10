package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.Utils.Constants;
import com.pragma.powerup.domain.api.ITraceServicePort;
import com.pragma.powerup.domain.model.Trace;
import com.pragma.powerup.domain.spi.ITracePersistencePort;
import com.pragma.powerup.domain.spi.IUserRestPort;
import lombok.RequiredArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
public class TraceUseCase implements ITraceServicePort {
    private final ITracePersistencePort tracePersistencePort;
    private final IUserRestPort userRestPort;

    @Override
    public void saveTrace(Trace trace) {
        trace.setEmailClient(getEmail(trace.getIdClient()));
        trace.setEmailChef(getEmail(trace.getIdChef()));
        trace.setDateTimeOrder(ZonedDateTime.now(ZoneId.of(Constants.TIME_ZONE)).toLocalDateTime());
        tracePersistencePort.saveTrace(trace);
    }

    @Override
    public List<Trace> getTracesByIdClientAndIdOrder(Long idClient, Long idOrder) {
        return tracePersistencePort.getTracesByIdClientAndIdOrder(idClient, idOrder);
    }

    private String getEmail(Long idUser) {
        return userRestPort.emailUser(idUser);
    }
}
