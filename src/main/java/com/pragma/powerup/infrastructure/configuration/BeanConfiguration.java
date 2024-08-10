package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.ITraceServicePort;
import com.pragma.powerup.domain.spi.ITracePersistencePort;
import com.pragma.powerup.domain.spi.IUserRestPort;
import com.pragma.powerup.domain.usecase.TraceUseCase;
import com.pragma.powerup.infrastructure.out.mongodb.adapter.TraceMongodbAdapter;
import com.pragma.powerup.infrastructure.out.mongodb.mapper.ITraceEntityMapper;
import com.pragma.powerup.infrastructure.out.mongodb.repository.ITraceRepository;
import com.pragma.powerup.infrastructure.out.rest.UserFeignClient;
import com.pragma.powerup.infrastructure.out.rest.UserRestAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITraceRepository traceRepository;
    private final ITraceEntityMapper traceEntityMapper;
    private final UserFeignClient userFeignClient;

    @Bean
    public ITracePersistencePort tracePersistencePort() {
        return new TraceMongodbAdapter(traceRepository, traceEntityMapper);
    }

    @Bean
    public IUserRestPort userRestPort(){
        return new UserRestAdapter(userFeignClient);
    }

    @Bean
    public ITraceServicePort traceServicePort() {
        return new TraceUseCase(tracePersistencePort(), userRestPort());
    }
}