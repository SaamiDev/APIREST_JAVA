package com.apirest.api_management.Controllers;


import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.Mappers.UserMapper;
import com.apirest.api_management.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    /**
     * Método para guardar un nuevo usuario en la base de datos.
     *
     * Este método recibe un objeto UserDTO que contiene los datos del usuario a guardar.
     * Se realiza la validación de que el DNI no esté registrado previamente y se convierte
     * el UserDTO a User antes de guardar en la base de datos.
     *
     * @param userDTO El objeto UserDTO que contiene los datos del usuario a guardar.
     * @return ResponseEntity con un objeto UserDTO del usuario creado y el código de estado HTTP 201 Created.
     *
     * @throws ResponseStatusException Si el DNI ya está registrado, se lanza una excepción con el código de estado HTTP 400 Bad Request.
     * @throws ResponseStatusException Si ocurre un error inesperado al procesar la solicitud, se lanza una excepción con el código de estado HTTP 500 Internal Server Error.
     */
    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
            try {
                UserDTO newUserDTO = userService.saveUser(userDTO);
                return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
            } catch (IllegalArgumentException e)  {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error al procesar la solicitud", e);
            }

    }


}
