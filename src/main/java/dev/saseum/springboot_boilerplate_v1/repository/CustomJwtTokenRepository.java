package dev.saseum.springboot_boilerplate_v1.repository;

import dev.saseum.springboot_boilerplate_v1.entity.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomJwtTokenRepository extends JpaRepository<JwtToken, UUID> {
    Optional<JwtToken> findByTokenOrRefreshToken(String token, String refreshToken);

    Optional<JwtToken> findByUserIdAndRefreshToken(UUID id, String refreshToken);
}
