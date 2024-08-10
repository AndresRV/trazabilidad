package com.pragma.powerup.domain.model;

import java.time.LocalDateTime;

public class Trace {
    private String id;
    private Long idOrder;
    private Long idClient;
    private String emailClient;
    private LocalDateTime dateTimeOrder;
    private OrderStatusEnum orderStatusOld;
    private OrderStatusEnum orderStatusNew;
    private Long idChef;
    private String emailChef;

    public Trace(String id, Long idOrder, Long idClient, String emailClient, LocalDateTime dateTimeOrder, OrderStatusEnum orderStatusOld, OrderStatusEnum orderStatusNew, Long idChef, String emailChef) {
        this.id = id;
        this.idOrder = idOrder;
        this.idClient = idClient;
        this.emailClient = emailClient;
        this.dateTimeOrder = dateTimeOrder;
        this.orderStatusOld = orderStatusOld;
        this.orderStatusNew = orderStatusNew;
        this.idChef = idChef;
        this.emailChef = emailChef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public LocalDateTime getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(LocalDateTime dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public OrderStatusEnum getOrderStatusOld() {
        return orderStatusOld;
    }

    public void setOrderStatusOld(OrderStatusEnum orderStatusOld) {
        this.orderStatusOld = orderStatusOld;
    }

    public OrderStatusEnum getOrderStatusNew() {
        return orderStatusNew;
    }

    public void setOrderStatusNew(OrderStatusEnum orderStatusNew) {
        this.orderStatusNew = orderStatusNew;
    }

    public Long getIdChef() {
        return idChef;
    }

    public void setIdChef(Long idChef) {
        this.idChef = idChef;
    }

    public String getEmailChef() {
        return emailChef;
    }

    public void setEmailChef(String emailChef) {
        this.emailChef = emailChef;
    }
}
