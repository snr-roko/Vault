package com.rokoinc.Vault.user;

import com.rokoinc.Vault.SortingOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(@RequestParam(value = "sort", defaultValue = "ASC") SortingOrder sort) {
        return userService.getAllUsers(sort);

    }

    @GetMapping("{id}")
    public User getUserById (@Valid @Positive @PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Optional<User> addUser(@Valid @RequestBody NewUserRequest newUser) {
        return userService.addUser(newUser);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@Valid @Positive @PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

}
