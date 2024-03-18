package com.TechSell.demo.controllers;

import com.TechSell.demo.models.LoginResult;
import com.TechSell.demo.models.Users;
import com.TechSell.demo.roles.UserRole;
import com.TechSell.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getUsers() {
        List<Users> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{email}")
    public UserDetails loadUserByUsername(@PathVariable("email") String email) {
        return userService.loadUserByUsername(email);
    }

    @GetMapping("/role/{email}")
    public UserRole getRole(@PathVariable("email") String email) {
        return userService.getRole(email);
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Users> addUser(@RequestBody Users u) {
        Users user = userService.addUser(u);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{password}")
    public ResponseEntity<Users> updatePassword(@PathVariable("id") int id, @PathVariable("password") String password) {
        userService.updatePassword(id, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login/{email}/{password}")
    public ResponseEntity<LoginResult> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        List<Users> users = userService.getUsers();
        LoginResult login = new LoginResult(false, "Invalid Credentials", null);
        for (int i = 0; i<users.size(); i++) {
            if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)) {
                login.setResult(true);
                login.setErrMessage("");
                login.setUser(users.get(i));
            }
        }
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

}
