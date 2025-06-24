package com.allan.P_Search_Username.service;

import com.allan.P_Search_Username.model.User;
import com.allan.P_Search_Username.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserMail(String userMail) {
    return userRepository.findByUserMailIgnoreCase(userMail);
    }
}
