package com.rokoinc.Vault.user;

import com.rokoinc.Vault.SortingOrder;
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
    public Optional<User> getUserById (@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Optional<User> addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

}
