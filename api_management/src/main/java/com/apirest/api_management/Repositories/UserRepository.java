package com.apirest.api_management.Repositories;

import com.apirest.api_management.DTOs.UserDTO;
import com.apirest.api_management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<UserDTO> findByDni(Long dni);
}
