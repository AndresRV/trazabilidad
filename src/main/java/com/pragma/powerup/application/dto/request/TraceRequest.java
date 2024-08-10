package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.domain.model.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TraceRequest {
    private Long idOrder;
    private Long idClient;
    private String emailClient;
    private OrderStatusEnum orderStatusOld;
    private OrderStatusEnum orderStatusNew;
    private Long idChef;
    private String emailChef;
}
