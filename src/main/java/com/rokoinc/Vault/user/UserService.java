package com.rokoinc.Vault.user;

import com.rokoinc.Vault.SortingOrder;
import com.rokoinc.Vault.exceptions.DuplicateResourceException;
import com.rokoinc.Vault.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(SortingOrder sort) {
        if (sort == SortingOrder.ASC) {
            return userRepository.getUsers()
                    .stream()
                    .sorted(Comparator.comparing(User::getId))
                    .collect(Collectors.toList());

        }

        return userRepository.getUsers()
                .stream()
                .sorted(Comparator.comparing(User::getId).reversed())
                .collect(Collectors.toList());
    }

    public User getUserById (Integer id) {
        return userRepository.getUsers()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    }

    public Optional<User> addUser(NewUserRequest newUser) {

        // reject if email exists already
        boolean emailExists = userRepository
                .getUsers()
                .stream()
                .anyMatch(user -> user.getEmail().equalsIgnoreCase(newUser.email()));
        if (emailExists) {
            throw new DuplicateResourceException("User already Exists");
        }

        // Create new user with auto-generated ID and current timestamps
        User createdUser = new User(
                userRepository.getIdCounter().incrementAndGet(),
                newUser.firstName(),
                newUser.lastName(),
                newUser.email(),
                newUser.phone(),
                newUser.dateOfBirth(),
                newUser.GPS(),
                newUser.city(),
                newUser.region(),
                newUser.zipCode(),
                newUser.gender(),
                LocalDate.now(),
                LocalDate.now()
        );

        // Add to the users collection
        userRepository.getUsers().add(createdUser);

        return Optional.of(createdUser);

    }

    public void deleteUser(Integer id) {
        boolean removed = userRepository.getUsers()
                .removeIf(user -> user.getId().equals(id));
        if (!removed) {
            throw new ResourceNotFoundException("User Not Found");
        }
    }

    // updating a user
    public void updateUser(Integer id, UpdateUserRequest userData) {
        User user = userRepository
                .getUsers()
                .stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        // update first name
        if ((userData.firstName() != null) && (!userData.firstName().equalsIgnoreCase(user.getFirstName()))) {
            user.setFirstName(userData.firstName());
        }

        // update last name
        if ((userData.lastName() != null) && (!userData.lastName().equalsIgnoreCase(user.getLastName()))) {
            user.setLastName(userData.lastName());
        }

        // update phone
        if ((userData.phone() != null) && (!userData.phone().equalsIgnoreCase(user.getPhone()))) {
            user.setPhone(userData.phone());
        }

        // update date of birth
        if ((userData.dateOfBirth() != null) && (userData.dateOfBirth() != user.getDateOfBirth())) {
            user.setDateOfBirth(userData.dateOfBirth());
        }

        // update GPS
        if ((userData.GPS() != null) && (!userData.GPS().equalsIgnoreCase(user.getGPS()))) {
            user.setGPS(userData.GPS());
        }

        // update city
        if ((userData.city() != null) && (!userData.city().equalsIgnoreCase(user.getCity()))) {
            user.setCity(userData.city());
        }

        // update region
        if ((userData.region() != null) && (!userData.region().equals(user.getRegion()))) {
            user.setRegion(userData.region());
        }

        // update zip code
        if ((userData.zipCode() != null) && (!userData.zipCode().equals(user.getZipCode()))) {
            user.setZipCode(userData.zipCode());
        }

        // update gender
        if ((userData.gender() != null) && (!userData.gender().equals(user.getGender()))) {
            user.setGender(userData.gender());
        }
    }

}
