package com.rokoinc.Vault.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwUtil jwUtil;
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, JwUtil jwUtil, AuthenticationService authenticationService) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwUtil = jwUtil;
        this.authenticationService = authenticationService;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        if (customUserDetailsService.existsByEmail(registerRequest.email())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        if (customUserDetailsService.existsByPhone(registerRequest.phone())) {
            return ResponseEntity.badRequest().body("Phone number already exists");
        }

        User newUser = authenticationService.registerUser(registerRequest);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(registerRequest.email());
        String token = jwUtil.generateToken(userDetails);

        return ResponseEntity.ok().body(new HashMap<String, Object>() {{
            put("token", token);
            put("user", userDetails);
            put("message", "User registered successfully! Welcome to Vault");
        }});
    }

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.email(),
                        loginRequest.password()
                )
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.email());

        String token = jwUtil.generateToken(userDetails);

        return ResponseEntity.ok().body(new HashMap<String, Object>() {{
            put("token", token);
            put("user", userDetails);
            put("message", "User logged in successfully! Welcome Back");
        }});
    }

    @PostMapping("validate")
    public ResponseEntity<?> validateToken(@Valid @RequestBody TokenValidityRequest tokenRequest) {
        String token = tokenRequest.token();
        if (jwUtil.isTokenValid(token)) {
            String username = jwUtil.extractUsername(token);
            return  ResponseEntity.ok().body(new HashMap<String, Object>() {{
                put("user", customUserDetailsService.loadUserByUsername(username));
                put("message", "Token Valid");
            }});
        } else {
            return ResponseEntity.badRequest().body("Invalid token");
        }
    }
}
