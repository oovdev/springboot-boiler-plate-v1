package dev.saseum.springboot_boilerplate_v1.repository;

import dev.saseum.springboot_boilerplate_v1.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SettingRepository extends JpaRepository<Setting, UUID> {
}
