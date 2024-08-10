package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.api.ITraceServicePort;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.ITracePersistencePort;
import com.pragma.powerup.domain.usecase.RestaurantUseCase;
import com.pragma.powerup.domain.usecase.TraceUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RestaurantJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import com.pragma.powerup.infrastructure.out.mongodb.adapter.TraceMongodbAdapter;
import com.pragma.powerup.infrastructure.out.mongodb.mapper.ITraceEntityMapper;
import com.pragma.powerup.infrastructure.out.mongodb.repository.ITraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    private final ITraceRepository traceRepository;
    private final ITraceEntityMapper traceEntityMapper;

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort());
    }

    @Bean
    public ITracePersistencePort tracePersistencePort() {
        return new TraceMongodbAdapter(traceRepository, traceEntityMapper);
    }

    @Bean
    public ITraceServicePort traceServicePort() {
        return new TraceUseCase(tracePersistencePort());
    }
}