package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.OrderStatusEnum;
import com.pragma.powerup.domain.model.Trace;
import com.pragma.powerup.domain.spi.ITracePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TraceUseCaseTest {
    @Mock
    private ITracePersistencePort tracePersistencePort;

    @InjectMocks
    private TraceUseCase traceUseCase;

    private Trace trace;

    @BeforeEach
    void setUp() {
        trace = new Trace(
                null,
                1L,
                1L,
                "xx",
                LocalDateTime.now(),
                OrderStatusEnum.PENDING,
                OrderStatusEnum.CANCELLED,
                1L,
                "xx"
        );
    }

    @Test
    void saveTrace() {
        traceUseCase.saveTrace(trace);

        verify(tracePersistencePort).saveTrace(trace);
    }

    @Test
    void getTracesByIdClient() {
        traceUseCase.getTracesByIdClient(1L);

        verify(tracePersistencePort).getTracesByIdClient(1L);
    }
}