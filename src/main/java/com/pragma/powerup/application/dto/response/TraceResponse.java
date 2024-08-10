package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TraceResponse {
    private Long idOrder;
    private Long idClient;
    private String emailClient;
    private LocalDateTime dateTimeOrder;
    private OrderStatusEnum orderStatusOld;
    private OrderStatusEnum orderStatusNew;
    private Long idChef;
    private String emailChef;
}
