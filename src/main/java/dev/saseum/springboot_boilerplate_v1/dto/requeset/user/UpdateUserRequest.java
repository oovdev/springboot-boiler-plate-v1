package dev.saseum.springboot_boilerplate_v1.dto.requeset.user;

import dev.saseum.springboot_boilerplate_v1.dto.annotation.FieldMatch;
import dev.saseum.springboot_boilerplate_v1.dto.annotation.MinListSize;
import dev.saseum.springboot_boilerplate_v1.dto.annotation.Password;
import dev.saseum.springboot_boilerplate_v1.dto.annotation.ValueOfEnum;
import dev.saseum.springboot_boilerplate_v1.util.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@FieldMatch(first = "password", second = "passwordConfirm", message = "{password_mismatch}")
public class UpdateUserRequest extends AbstractBaseUpdateUserRequest {
    @Password(message = "{invalid_password}")
    @Schema(
            name = "password",
            description = "Password of the user",
            type = "String",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            example = "P@sswd123."
    )
    private String password;

    @Schema(
            name = "passwordConfirm",
            description = "Password for confirmation",
            type = "String",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            example = "P@sswd123."
    )
    private String passwordConfirm;

    @MinListSize(min = 1, message = "{min_list_size}")
    @Schema(
            name = "roles",
            description = "Roles of the user",
            type = "List<String>",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            allowableValues = {"ADMIN", "USER"},
            example = "[\"USER\"]"
    )
    private List<@ValueOfEnum(enumClass = Constants.RoleEnum.class) String> roles;

    @Schema(
            name = "isEmailVerified",
            description = "Is the user's email verified",
            type = "Boolean",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            example = "true"
    )
    @Builder.Default
    private Boolean isEmailVerified = false;

    @Schema(
            name = "isBlocked",
            description = "Is the user blocked",
            type = "Boolean",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            example = "false"
    )
    @Builder.Default
    private Boolean isBlocked = false;
}
