package com.rokoinc.Vault.user;

import com.rokoinc.Vault.SortingOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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

    public Optional<User> getUserById (Integer id) {
        return userRepository.getUsers()
                .stream()
                .filter(user -> user.getId().equals(id)).findFirst();
    }

    public Optional<User> addUser(User newUser) {
        // Create new user with auto-generated ID and current timestamps
        User createdUser = new User(
                userRepository.getIdCounter().incrementAndGet(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getPhone(),
                newUser.getDateOfBirth(),
                newUser.getGPS(),
                newUser.getCity(),
                newUser.getRegion(),
                newUser.getZipCode(),
                newUser.getGender(),
                LocalDate.now(),
                LocalDate.now()
        );

        // Add to the users collection
        userRepository.getUsers().add(createdUser);

        return Optional.of(createdUser);

    }

    public void deleteUser(Integer id) {
        userRepository.getUsers().removeIf(user -> user.getId().equals(id));
    }

}
