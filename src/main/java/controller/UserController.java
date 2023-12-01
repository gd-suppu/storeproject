package controller;
import entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private Map<String, User> users = new HashMap<>();

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String email = user.getEmail();

        // Check if the user with the provided email already exists
        if (users.containsKey(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        // If the user doesn't exist, add them to the map
        users.put(email, user);
        return ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
    }
}

