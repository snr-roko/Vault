package com.rokoinc.Vault.user;




import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(RegisterRequest registerRequest) {
        validateRegistrationData(registerRequest);

        String hashedPassword = passwordEncoder.encode(registerRequest.password());

        User newUser = new User(
            registerRequest.firstName(),
            registerRequest.lastName(),
            registerRequest.email(),
            registerRequest.phone(),
            registerRequest.dateOfBirth(),
            registerRequest.GPS(),
            registerRequest.city(),
            registerRequest.region(),
            registerRequest.gender(),
            hashedPassword,
            Role.CUSTOMER
        );

        return userRepository.save(newUser);




    }

    private void validateRegistrationData(RegisterRequest registerRequest) {

        if (!registerRequest.password().equals(registerRequest.confirmPassword())) {
            throw new IllegalArgumentException(
                    "Passwords do not match"
            );
        }

        LocalDate eighteenYearsAgo = LocalDate.now().minusYears(18);

        if (registerRequest.dateOfBirth().isAfter(eighteenYearsAgo))
            throw new IllegalArgumentException("You must be at least 18 years old to use our banking services");

        String password =  registerRequest.password();
        if (password.contains(registerRequest.firstName().toLowerCase()) ||
                password.contains(registerRequest.lastName().toLowerCase())
        ){
            throw new IllegalArgumentException(
                    "Password should not contain your name"
            );
        }

    }
}
