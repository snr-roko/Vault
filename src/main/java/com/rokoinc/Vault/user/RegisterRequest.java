package com.rokoinc.Vault.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record RegisterRequest(
        @NotNull(message = "First Name is required") String firstName,
        @NotNull(message = "Last Name is required") String lastName,
        @NotNull(message = "Email is required") @Email(message = "Email must be a valid email") String email,
        @NotNull(message = "Phone number is required") String phone,
        @NotNull(message = "Date of Birth is required") @Past(message = "Date of Birth must be in the past") LocalDate dateOfBirth,
        @NotNull(message = "GPS is required") String GPS,
        @NotNull(message = "City is required") String city,
        @NotNull(message = "Region is required") String region,
        @NotNull(message = "Gender is required") Gender gender,
        @NotNull(message = "Password is required") String password,
        @NotNull(message = "Confirm Password") String confirmPassword
) {
}
