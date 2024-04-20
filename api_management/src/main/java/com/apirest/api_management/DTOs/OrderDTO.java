package com.apirest.api_management.DTOs;


import java.time.LocalDateTime;

import com.apirest.api_management.entities.Enums.OrderStatus;

public class OrderDTO {
    private Long id;
    private String customUniqueId;
    private String orderDescription;
    private LocalDateTime registrationDate;
    private OrderStatus status;
    private UserDTO userDTO;
    private CourierCompanyDTO CourierCompanyDTO;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String customUniqueId, String orderDescription, LocalDateTime registrationDate, OrderStatus status, UserDTO userDTO, CourierCompanyDTO CourierCompanyDTO) {
        this.id = id;
        this.customUniqueId = customUniqueId;
        this.orderDescription = orderDescription;
        this.registrationDate = registrationDate;
        this.status = status;
        this.userDTO = userDTO;
        this.CourierCompanyDTO = CourierCompanyDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomUniqueId() {
        return customUniqueId;
    }

    public void setCustomUniqueId(String customUniqueId) {
        this.customUniqueId = customUniqueId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public CourierCompanyDTO getCourierCompanyDTO() {
        return CourierCompanyDTO;
    }

    public void setCourierCompanyDTO(CourierCompanyDTO courierCompanyDTO) {
        CourierCompanyDTO = courierCompanyDTO;
    }
}
