package com.rokoinc.Vault.user;

import jakarta.validation.constraints.NotNull;

public record TokenValidityRequest(
        @NotNull(message = "Token is required") String token
        ) {
}
