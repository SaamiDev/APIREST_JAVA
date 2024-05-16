package com.apirest.api_management.Services;

import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.Mappers.UserMapper;
import com.apirest.api_management.Repositories.UserRepository;
import com.apirest.api_management.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



/**
 * Esta clase proporciona servicios relacionados con la gestión de usuarios.
 * Utiliza UserRepository para interactuar con la base de datos y UserMapper para
 * transformar entre User y UserDTO.
 */
@Service
public class UserService {

    /**
     * Repositorio que proporciona métodos para interactuar con la base de datos
     * y realizar operaciones CRUD relacionadas con la entidad User.
     */
    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * Mapper que proporciona métodos para transformar objetos User a UserDTO y viceversa.
     */
    private final UserMapper userMapper;

    /**
     * Constructor que inyecta las dependencias UserRepository y UserMapper.
     *
     * @param userRepository Repositorio para interactuar con la base de datos.
     * @param userMapper     Mapper para transformaciones entre User y UserDTO.
     */
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param userDTO DTO del usuario a guardar.
     * @return DTO del usuario guardado.
     */
    public UserDTO saveUser(UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findByDni(userDTO.getUserDni());

        if(existingUser.isPresent()) {
            throw new IllegalArgumentException("El dni ya está registrado");
        }

        User user = userMapper.userDTOToUser(userDTO);
        user = userRepository.save(user);


        return userMapper.userToUserDTO(user);
    }


    public UserDTO getUserById(String idUser) {
        logger.info("Attempting to GET User with idUser: {}", idUser);
        // FALLA AQUÍ REVISAR MÉTODO FINDBYIDUSER
        Optional<User> existingUser = userRepository.findByIdUser(idUser);

        if(!existingUser.isPresent()) {
            throw new IllegalArgumentException("User not found with idUser: " + idUser);

        }

        User user = existingUser.get();
        UserDTO userDTO = userMapper.userToUserDTO(user);

        return userDTO;
    }


    /**
     * Recupera un usuario por su DNI.
     *
     * @param dni DNI del usuario a buscar.
     * @return DTO del usuario encontrado o null si no se encuentra.
    **/
    public UserDTO getUserByDni(String userDTO) {
        // Busca al usuario por DNI y devuelve un Optional<UserDTO>
        Optional<User> existingUser = userRepository.findByDni(userDTO);

        // Verifica si se encontró un usuario con el DNI especificado
        if (existingUser.isPresent()) {
            // Si se encontró, devuelve el usuario encontrado
            return userMapper.userToUserDTO(existingUser.get());

        } else {
            // Si no se encontró ningún usuario, puedes manejarlo de acuerdo a tus requisitos, por ejemplo, lanzar una excepción o devolver un valor predeterminado
            //throw new UserNotFoundException("User with DNI " + userDTO.getUserDni() + " not found");
            // O puedes devolver un UserDTO vacío o con valores por defecto, dependiendo de tu caso de uso
             return new UserDTO();
        }
    }

    public void deleteUser(String dni) {
        logger.info("Attempting to delete user with DNI: {}", dni);
        Optional<User> existingUser = userRepository.findByDni(dni);

        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());

        } else {
            logger.warn("User with DNI {} not found", dni);
            throw new IllegalArgumentException("User not found with DNI: " + dni);
        }


    }

}

