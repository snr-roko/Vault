package com.rokoinc.Vault.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UpdateUserRequest(
        String firstName,
        String lastName,
        String phone,
        @Past(message = "Date of Birth must be in the past") LocalDate dateOfBirth,
        String GPS,
        String city,
        String region,
        String zipCode,
        Gender gender
) {
}
