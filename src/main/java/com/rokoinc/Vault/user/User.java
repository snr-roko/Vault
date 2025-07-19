package com.rokoinc.Vault.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// User Model Class
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // first Name
    @NotBlank(message = "First Name is required")
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String firstName;

    //last name
    @Size(min = 1, max = 50)
    @NotBlank(message = "Last Name is required")
    @Column(nullable = false, length = 50)
    private String lastName;

    // email
    @Email(message = "Email must be a valid Email")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    // phone
    @NotBlank(message = "Phone is required")
    @Size(min=13, max = 15)
    @Column(nullable = false, length = 15, unique = true)
    private String phone;

    // date of birth
    @NotBlank(message = "Date of Birth is required")
    @Column(nullable = false)
    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;

    // GPS
    @NotBlank(message = "GPS is required")
    @Size(min = 8, max = 15)
    @Column(nullable = false, length = 15)
    private String GPS;

    // city
    @NotBlank(message = "City is required")
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String city;

    // region
    @NotBlank(message = "Region is required")
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String region;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Gender is required")
    @Size(min = 4, max = 7)
    @Column(length = 7, nullable = false)
    private Gender gender;

    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private LocalDate updatedAt;

    // password
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be at least 8 characters long")
    @Column(nullable = false)
    private String password;

    // role
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;

    // add no arg constructor
    public User () {

    }

    // constructor argument
    public User(String firstName, String lastName, String email, String phone, LocalDate dateOfBirth, String GPS, String city, String region, Gender gender, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.GPS = GPS;
        this.city = city;
        this.region = region;
        this.gender = gender;
        this.password = password;
        this.role = role;
    }

    public User(String firstName, String lastName, String email, String phone, LocalDate dateOfBirth, String GPS, String city, String region, Gender gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.GPS = GPS;
        this.city = city;
        this.region = region;
        this.gender = gender;
        this.password = password;
    }

    // Method to automatically create createdAt and updatedAt fields
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        updatedAt = LocalDate.now();
    }

    // Method to automatically update updatedAt during updating user
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }

    // User details methods override
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_" + role)
        );
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }


    // standard getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
}

