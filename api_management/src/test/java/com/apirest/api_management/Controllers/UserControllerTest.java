package com.apirest.api_management.Controllers;


import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.Services.UserService;
import com.apirest.api_management.TestsUtils.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(UserController.class )
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        UserDTO userDTO = new UserDTO(DataGenerator.getRandomName(), DataGenerator.getRandomSurname(), DataGenerator.getRandomDni());
    }

    @Test
    void testSaveUserSuccess() throws Exception {
         
    }
}
