package com.apirest.api_management.entities;

//import api_management.src.main.java.com.apirest.api_management.Entities.Enums.OrderStatus;

import javax.persistence.*;

import com.apirest.api_management.entities.Enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", unique = true, updatable = false, nullable = false)
    private String customUniqueId;

    @Column(name = "order_desc")
    private String orderDescription;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "courier_company_id")
    private CourierCompany courierCompany;


    private void setCustomUniqueId() {
        customUniqueId = "ORDER_" + UUID.randomUUID() + "_" + System.currentTimeMillis();
    }

    private void setRegistration_date() {
        registrationDate = LocalDateTime.now();
    }

    @PrePersist
    private void onCreate() {
        setCustomUniqueId();
        setRegistration_date();
    }
}
