package com.pragma.powerup.infrastructure.out.rest;

import com.pragma.powerup.domain.spi.IUserRestPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRestAdapter implements IUserRestPort {
    private final UserFeignClient userFeignClient;

    @Override
    public String emailUser(Long idUser) {
        return userFeignClient.emailUser(idUser);
    }
}
