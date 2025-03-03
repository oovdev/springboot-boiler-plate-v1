package dev.saseum.springboot_boilerplate_v1.controller;

import dev.saseum.springboot_boilerplate_v1.dto.requeset.user.UpdatePasswordRequest;
import dev.saseum.springboot_boilerplate_v1.dto.response.DetailedErrorResponse;
import dev.saseum.springboot_boilerplate_v1.dto.response.ErrorResponse;
import dev.saseum.springboot_boilerplate_v1.dto.response.SuccessResponse;
import dev.saseum.springboot_boilerplate_v1.dto.response.user.UserResponse;
import dev.saseum.springboot_boilerplate_v1.service.MessageSourceService;
import dev.saseum.springboot_boilerplate_v1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import static dev.saseum.springboot_boilerplate_v1.util.Constants.SECURITY_SCHEME_NAME;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
@Tag(name = "002. Account", description = "Account API")
public class AccountController extends AbstractBaseController {
    private final UserService userService;

    private final MessageSourceService messageSourceService;

    @GetMapping("/me")
    @Operation(
            summary = "Me endpoint",
            security = @SecurityRequirement(name = SECURITY_SCHEME_NAME),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Bad credentials",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )
    public ResponseEntity<UserResponse> me() {
        return ResponseEntity.ok(UserResponse.convert(userService.getUser()));
    }

    @PostMapping("/password")
    @Operation(
            summary = "Password update endpoint",
            security = @SecurityRequirement(name = SECURITY_SCHEME_NAME),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SuccessResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Bad credentials",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Validation failed",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DetailedErrorResponse.class)
                            )
                    )
            }
    )
    public ResponseEntity<SuccessResponse> password(
            @Parameter(description = "Request body to update password", required = true)
            @RequestBody @Valid UpdatePasswordRequest request
    ) throws BindException {
        userService.updatePassword(request);

        return ResponseEntity.ok(SuccessResponse.builder()
                .message(messageSourceService.get("your_password_updated"))
                .build());
    }

    @GetMapping("/resend-email-verification")
    @Operation(
            summary = "Resend e-mail verification endpoint",
            security = @SecurityRequirement(name = SECURITY_SCHEME_NAME),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SuccessResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Bad credentials",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )
    public ResponseEntity<SuccessResponse> resendEmailVerificationMail() {
        userService.resendEmailVerificationMail();

        return ResponseEntity.ok(SuccessResponse.builder()
                .message(messageSourceService.get("verification_email_sent"))
                .build());
    }
}
