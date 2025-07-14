package com.rokoinc.Vault.user;

import com.rokoinc.Vault.SortingOrder;
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

    public Optional<User> getUserById (Integer id) {
        return userRepository.getUsers()
                .stream()
                .filter(user -> user.getId().equals(id)).findFirst();
    }

    public Optional<User> addUser(NewUserRequest newUser) {
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
        userRepository.getUsers().removeIf(user -> user.getId().equals(id));
    }

}
