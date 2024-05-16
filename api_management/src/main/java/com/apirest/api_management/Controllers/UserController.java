package com.apirest.api_management.Controllers;


import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.Mappers.UserMapper;
import com.apirest.api_management.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


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
            logger.info("Received request to save User: {}", userDTO);
            try {
                UserDTO newUserDTO = userService.saveUser(userDTO);
                logger.info("User saved successfully: {}", userDTO);
                return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
            } catch (IllegalArgumentException e)  {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            } catch (Exception e) {
                logger.error("Error ocurred while saving User: {}", e.getMessage());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while processing the request", e);
            }

    }


    /**
     * Elimina un usuario basado en su DNI.
     *
     * @param dni El DNI del usuario que se desea eliminar.
     * @return ResponseEntity con el estado HTTP adecuado.
     *         - {@code 204 No Content} si el usuario fue eliminado exitosamente.
     *         - {@code 400 Bad Request} si el usuario no existe o el DNI es inválido.
     *         - {@code 500 Internal Server Error} si ocurre un error en el servidor.
     * @throws ResponseStatusException si ocurre un error durante el proceso de eliminación.
     */
    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<Void> deleteUser(@PathVariable String IdUser) {
        logger.info("Received request to delete User whith idUser: {}", IdUser);
        try {
            userService.deleteUser(IdUser);
            logger.info("User deleted successfully whith idUser: {}", IdUser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            logger.error("Error ocurred while deleting User: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while processing the request", e);
        }
    }



    @GetMapping("/get/{idUser}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String idUser) {

        logger.info("Received request to get User whith id: {}", idUser);
        try {
            UserDTO getUserDTO = userService.getUserById(idUser);
            logger.info("User achieved successfully: {}");
            return new ResponseEntity<>(getUserDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            logger.error("Error ocurred while getting User: {}");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while processing the request", e);
        }

    }


}
