package com.allan.P_Search_Username.repository;

import com.allan.P_Search_Username.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserMailIgnoreCase(String userMail);
}
