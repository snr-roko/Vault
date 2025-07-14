package com.rokoinc.Vault.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record NewUserRequest(
        @NotNull String firstName,
        @NotNull String lastName,
        @Email String email,
        @NotNull String phone,
        @Past LocalDate dateOfBirth,
        @NotNull String GPS,
        @NotNull String city,
        @NotNull String region,
        @NotNull String zipCode,
        @NotNull Gender gender
) {
}
