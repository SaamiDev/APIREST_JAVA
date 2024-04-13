package com.apirest.api_management.Services;

import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.Mappers.UserMapper;
import com.apirest.api_management.Repositories.UserRepository;
import com.apirest.api_management.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User user = userMapper.userDTOToUser(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    /**
     * Recupera un usuario por su DNI.
     *
     * @param dni DNI del usuario a buscar.
     * @return DTO del usuario encontrado o null si no se encuentra.
     */
    public UserDTO getUserByDni(Long dni) {
        User user = userRepository.findByDni(dni);
        return user != null ? userMapper.userToUserDTO(user) : null;
    }
}