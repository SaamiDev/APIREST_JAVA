package com.apirest.api_management.Repositories;

import com.apirest.api_management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByDni(Long dni);
}
