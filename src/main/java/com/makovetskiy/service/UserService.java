package com.makovetskiy.service;

import com.makovetskiy.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<List<User>> getAll();

    User add(User user);

    Optional<User> getById(Long id);

    Optional<User> update(User user);

    void delete(Long id);
}
