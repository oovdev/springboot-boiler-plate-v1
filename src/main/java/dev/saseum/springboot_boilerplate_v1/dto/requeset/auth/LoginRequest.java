package dev.saseum.springboot_boilerplate_v1.dto.requeset.auth;

import dev.saseum.springboot_boilerplate_v1.dto.annotation.Password;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "{not_blank}")
    @Schema(
            name = "email",
            description = "E-mail of the user",
            type = "String",
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "mail@example.com"
    )
    private String email;

    @NotBlank(message = "{not_blank}")
    @Password(message = "{invalid_password}")
    @Schema(
            name = "password",
            description = "Password of the user",
            type = "String",
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "P@sswd123."
    )
    private String password;

    @Schema(
            name = "rememberMe",
            description = "Remember option for refresh token",
            type = "Boolean",
            example = "true"
    )
    private Boolean rememberMe;
}
