package com.allan.P_Search_Username.controller;

import com.allan.P_Search_Username.model.User;
import com.allan.P_Search_Username.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/search-user")
    public ResponseEntity<?> searchUserByEmail(@RequestBody EmailRequest request) {
        Optional<User> user = userRepository.findByUserMailIgnoreCase(request.getUser_mail());

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    public static class EmailRequest {
        private String user_mail;

        public String getUser_mail() {
            return user_mail;
        }

        public void setUser_mail(String user_mail) {
            this.user_mail = user_mail;
        }
    }
}
