package com.pragma.powerup.infrastructure.out.mongodb.entity;

import com.pragma.powerup.domain.model.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "trace")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TraceEntity {
    @Id
    private String id;
    private Long idOrder;
    private Long idClient;
    private String emailClient;
    private LocalDateTime dateTimeOrder;
    private OrderStatusEnum orderStatusOld;
    private OrderStatusEnum orderStatusNew;
    private Long idChef;
    private String emailChef;
}
