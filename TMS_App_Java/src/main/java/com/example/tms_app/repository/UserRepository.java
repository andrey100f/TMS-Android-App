package com.example.tms_app.repository;

import com.example.tms_app.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    User getUserByUserId(UUID userId);
    User getUserByUsername(String username);
}
