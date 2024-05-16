package com.apirest.api_management.Mappers;

import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 * Interfaz que define las operaciones de mapeo entre la entidad User y su correspondiente DTO.
 * Utiliza MapStruct para generar automáticamente las implementaciones de estos métodos.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    // Instancia del mapper generada por MapStruct
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * Convierte un objeto User a un UserDTO.
     *
     * @param user El objeto User a convertir.
     * @return El UserDTO resultante.
     */

    @SuppressWarnings("unmappedTargetProperties")
    @Mapping(target = "userId", source = "idUser")
    @Mapping(target = "userName", source = "name")
    @Mapping(target = "userSurnames", source = "surnames")
    @Mapping(target = "userDni", source = "dni")
    @Mapping(target = "userEmail", source = "email")
    UserDTO userToUserDTO(User user);

    /**
     * Convierte un objeto UserDTO a un User.
     *
     * @param userDTO El objeto UserDTO a convertir.
     * @return El User resultante.
     */
    @Mapping(target = "idUser", source = "userId")
    @Mapping(target = "name", source = "userName")
    @Mapping(target = "surnames", source = "userSurnames")
    @Mapping(target = "dni", source = "userDni")
    @Mapping(target = "email", source = "userEmail")
    User userDTOToUser(UserDTO userDTO);

}
