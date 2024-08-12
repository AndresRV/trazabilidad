package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.OrderStatusEnum;
import com.pragma.powerup.domain.model.Trace;
import com.pragma.powerup.domain.spi.ITracePersistencePort;
import com.pragma.powerup.domain.spi.IUserRestPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TraceUseCaseTest {
    @Mock
    private ITracePersistencePort tracePersistencePort;
    @Mock
    private IUserRestPort userRestPort;

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
        when(userRestPort.emailUser(anyLong())).thenReturn(anyString());

        traceUseCase.saveTrace(trace);

        verify(tracePersistencePort).saveTrace(trace);
    }

    @Test
    void getTracesByIdClient() {
        traceUseCase.getTracesByIdClientAndIdOrder(1L, 1L);

        verify(tracePersistencePort).getTracesByIdClientAndIdOrder(1L, 1L);
    }
}