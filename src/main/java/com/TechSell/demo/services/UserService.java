package com.TechSell.demo.services;

import com.TechSell.demo.models.Users;
import com.TechSell.demo.repos.UserRepo;
import com.TechSell.demo.roles.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s was not found";

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<Users> getUsers() {
       return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepo.findByEmail(email).orElseThrow( () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public UserRole getRole(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow( () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)))
                .getUserRole();
    }

    public Users getUserById(int id) throws UsernameNotFoundException {
        return userRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, id)));
    }

    public Users addUser(Users user) {
        return userRepo.save(user);
    }

    public void deleteUser(int id) { userRepo.deleteById(id); }

    public Users updatePassword(int id, String password) {
        userRepo.getById(id).setPassword(password);
        return userRepo.save(userRepo.getById(id));
    }

}
