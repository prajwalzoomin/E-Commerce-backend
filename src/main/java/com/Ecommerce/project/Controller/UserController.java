// UserController.java
package com.Ecommerce.project.Controller;

import com.Ecommerce.project.Entities.User;
import com.Ecommerce.project.Service.UserService;
//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<String> registerUser( @RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully and your Id is:\n" + user.getId());
    }

    @GetMapping("/{Id}")
    public User getUserById(@PathVariable Integer Id) {
        return userService.getUserById(Id);
    }

}
