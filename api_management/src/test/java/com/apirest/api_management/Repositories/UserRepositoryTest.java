package com.apirest.api_management.Repositories;

import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.Mappers.UserMapper;
import com.apirest.api_management.Services.UserService;
import com.apirest.api_management.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static com.apirest.api_management.TestsUtils.DataGenerator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Integra las pruebas del UserRepository dentro de un contexto Spring Boot.
 * Esta clase de prueba asegura que las entidades de usuario se persistan y recuperen correctamente
 * utilizando el UserService y el UserMapper para transformaciones entre objetos DTO y entidades.
 *
 * La anotación @SpringBootTest indica a Spring Boot que busque una clase de configuración principal
 * (una con @SpringBootApplication, por ejemplo) y utilice esa para iniciar un contexto de aplicación Spring.
 */
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserService userService;

    // Instancia de UserRepository (aunque no se use, puede necesitar ser autowired o eliminada)
    private UserRepository userRepository;

    // Instancia de UserMapper para la conversión entre UserDTO y entidad User
    private UserMapper userMapper;

    /**
     * Método de configuración que inicializa la instancia de UserMapper antes de cada ejecución de prueba.
     * Esto asegura que el mapper se instancie correctamente para cada caso de prueba.
     */
    @BeforeEach
    public void setUp() {
        userMapper = Mappers.getMapper(UserMapper.class);
    }

    /**
     * Prueba el guardado de una entidad User a través del UserService para validar que el usuario
     * se persiste correctamente y que el campo DNI es consistente entre el DTO y la entidad.
     * Esta prueba genera datos de usuario aleatorios para simular la adición de un nuevo usuario.
     */
    @Test
    public void testSaveUser() {

        // Prepara un UserDTO con nombre, apellido y DNI aleatorios
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(getRandomName());
        userDTO.setUserSurnames(getRandomSurname());
        userDTO.setUserDni(getRandomDni());

        // Convierte UserDTO a entidad User usando UserMapper
        //User userSave = userMapper.userDTOToUser(userDTO);

        // Guarda la entidad User usando UserService
          User savedUser = userMapper.userDTOToUser(userService.saveUser(userDTO));

        // Asegura que el DNI del usuario guardado coincide con el DNI en el UserDTO original
        assertEquals(savedUser.getDni(), userDTO.getUserDni(), "El DNI del usuario no coincide después de la persistencia");
    }

    @Test
    public void testGetUserByDni() {
        // Crear un UserDTO con datos aleatorios
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(getRandomName());
        userDTO.setUserSurnames(getRandomSurname());
        userDTO.setUserDni(getRandomDni());

        // Guardar el UserDTO
        UserDTO savedUserDTO = userService.saveUser(userDTO);
        Long savedUserDni = savedUserDTO.getUserDni();

        // Obtener el UserDTO por su DNI usando el servicio
        UserDTO retrievedUserDTO = userService.getUserByDni(savedUserDni);

        // Asegurarse de que retrievedUserDTO no es null
        assertNotNull(retrievedUserDTO, "El usuario no se recuperó correctamente por DNI");

        // Asegurarse de que los campos del usuario guardado son iguales a los del usuario recuperado
        assertEquals(userDTO.getUserName(), retrievedUserDTO.getUserName(), "El nombre del usuario guardado no coincide con el del recuperado");
        assertEquals(userDTO.getUserSurnames(), retrievedUserDTO.getUserSurnames(), "Los apellidos del usuario guardado no coinciden con los del recuperado");
        assertEquals(userDTO.getUserDni(), retrievedUserDTO.getUserDni(), "El DNI del usuario guardado no coincide con el del recuperado");
    }

}
