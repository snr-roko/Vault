package com.rokoinc.Vault.user;

public record LoginRequest(
        String email,
        String password
) {
}
