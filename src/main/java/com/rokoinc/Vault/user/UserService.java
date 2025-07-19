package com.rokoinc.Vault.user;

import com.rokoinc.Vault.SortingOrder;
import com.rokoinc.Vault.exceptions.DuplicateResourceException;
import com.rokoinc.Vault.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(SortingOrder sort) {
        return userRepository
                .findAll(
                        Sort.by(
                                Sort.Direction.valueOf(sort.name()),
                                "id"
                        )
                );
    }

    public User getUserById (Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    }

    public Optional<User> addUser(RegisterRequest newUser) {

        // reject if email exists already
        boolean emailExists = userRepository.existsByEmail(newUser.email());
        if (emailExists) {
            throw new DuplicateResourceException("User already Exists");
        }

        // Create new user with auto-generated ID and current timestamps
        User createdUser = new User(
                newUser.firstName(),
                newUser.lastName(),
                newUser.email(),
                newUser.phone(),
                newUser.dateOfBirth(),
                newUser.GPS(),
                newUser.city(),
                newUser.region(),
                newUser.gender(),
                newUser.password()
        );

        // save to database
        userRepository.save(createdUser);

        return Optional.of(createdUser);

    }

    public void deleteUser(Integer id) {
        boolean userExists = userRepository.existsById(id);
        if (!userExists) {
            throw new ResourceNotFoundException("User Not Found");
        }

        userRepository.deleteById(id);
    }

    // updating a user
    public void updateUser(Integer id, UpdateUserRequest userData) {
        User user = userRepository
                .findById(id)
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


        // update gender
        if ((userData.gender() != null) && (!userData.gender().equals(user.getGender()))) {
            user.setGender(userData.gender());
        }

        userRepository.save(user);
    }

}
