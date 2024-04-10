package api_management.src.main.java.com.apirest.api_management.DTOs;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String surnames;
    private Long dni;
    private List<OrderDTO> orderList = new ArrayList<>();


}
