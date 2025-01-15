package dev.saseum.springboot_boilerplate_v1.dto.requeset.auth;

import dev.saseum.springboot_boilerplate_v1.dto.requeset.user.AbstractBaseCreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class RegisterRequest extends AbstractBaseCreateUserRequest {
}
