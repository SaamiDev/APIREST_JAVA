package com.apirest.api_management.Mappers;

import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de prueba para la clase UserMapper.
 * Esta clase se utiliza para probar los métodos de mapeo definidos en UserMapper.
 */
public class UserMapperTest {

    private UserMapper userMapper; // Mapper que se va a probar

    /**
     * Configuración inicial.
     * En este caso, se inicializa el mapper que se va a probar.
     */
    @BeforeEach
    public void setUp() {
        userMapper = Mappers.getMapper(UserMapper.class);
    }

    /**
     * Método de prueba para verificar el correcto mapeo de User a UserDTO.
     */
    @Test
    public void testUserToUserDTO() {
        // (Configuración inicial)
        User user = new User();
        user.setName("Samuel");
        user.setSurnames("Pulido");
        user.setDni(123456789L);

        // Act (Acción: ejecutar el método que se va a probar)
        UserDTO userDTO = userMapper.userToUserDTO(user);

        // Assert (Verificación: afirmar que el resultado es el esperado)
        assertEquals(user.getName(), userDTO.getUserName(), "El nombre no se mapeó correctamente");
        assertEquals(user.getSurnames(), userDTO.getUserSurnames(), "Los apellidos no se mapearon correctamente");
        assertEquals(user.getDni(), userDTO.getUserDni(), "El DNI no se mapeó correctamente");
        //assertEquals(user.getDni(), userDTO.getUserName(), "El DNI no se mapeó correctamente: Se esperaba " + user.getDni() + " pero se recibe " + userDTO.getUserName());

    }

    @Test
    public void testUserDTOtoUser() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("Sergio");
        userDTO.setUserSurnames("Nunez");
        userDTO.setUserDni(987654321L);

        User user = userMapper.userDTOToUser(userDTO);

        assertEquals(userDTO.getUserName(), user.getName(), "El nombre no se mapeó correctamente");
        assertEquals(userDTO.getUserSurnames(), user.getSurnames(), "Los apellidos no se mapearon correctamente");
        assertEquals(userDTO.getUserDni(), user.getDni(), "El DNI no se mapeó correctamente");

    }



}
