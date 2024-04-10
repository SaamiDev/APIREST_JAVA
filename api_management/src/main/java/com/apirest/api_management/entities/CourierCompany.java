package api_management.src.main.java.com.apirest.api_management.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "courier_companies")
public class CourierCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id", unique = true, updatable = false, nullable = false)
    private String companyId;

    @Column(name = "image_name")
    private String imageName;

    @OneToMany(mappedBy  = "courierCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();



    @PrePersist
    private void onCreate(){
        setCompanyId();
    }

    private void setCompanyId() {
          companyId = "COMPANY_" + UUID.randomUUID() + "_" + System.currentTimeMillis();
    }

}
