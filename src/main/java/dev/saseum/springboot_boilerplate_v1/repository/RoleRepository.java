package dev.saseum.springboot_boilerplate_v1.repository;

import dev.saseum.springboot_boilerplate_v1.entity.Role;
import dev.saseum.springboot_boilerplate_v1.util.Constants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(Constants.RoleEnum name);
}
