// UserService.java
package com.Ecommerce.project.Service;

import com.Ecommerce.project.Entities.User;
import java.util.Optional;

public interface UserService {

    void registerUser(User user);

    Optional<User> getUserByUsername(String username);

    User getUserById(Integer userId);

    Optional<User> getUserByEmail(String email);
}