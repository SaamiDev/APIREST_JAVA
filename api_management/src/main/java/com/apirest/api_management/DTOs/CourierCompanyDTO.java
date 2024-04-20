package com.apirest.api_management.DTOs;

import java.util.ArrayList;
import java.util.List;

public class CourierCompanyDTO {

    private Long id;
    private String companyId;
    private String imageName;
    private List<OrderDTO> ordersDTO = new ArrayList<>();

    // Constructor vacío
    public CourierCompanyDTO() {
    }

    // Constructor con todos los atributos
    public CourierCompanyDTO(Long id, String companyId, String imageName, List<OrderDTO> ordersDTO) {
        this.id = id;
        this.companyId = companyId;
        this.imageName = imageName;
        this.ordersDTO = ordersDTO;
    }

    // Getters y setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<OrderDTO> getOrdersDTO() {
        return ordersDTO;
    }

    public void setOrdersDTO(List<OrderDTO> ordersDTO) {
        this.ordersDTO = ordersDTO;
    }
}