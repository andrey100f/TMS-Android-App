package com.example.tms_app.repository;

import com.example.tms_app.models.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, UUID> {
    UserRole getUserRoleByRoleId(UUID userRoleId);
}
