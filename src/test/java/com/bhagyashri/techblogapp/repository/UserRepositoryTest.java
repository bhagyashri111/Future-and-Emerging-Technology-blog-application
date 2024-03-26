package com.bhagyashri.techblogapp.repository;

import com.bhagyashri.techblogapp.TechblogappApplicationTests;
import com.bhagyashri.techblogapp.dto.RegistrationDto;
import com.bhagyashri.techblogapp.entity.User;
import com.bhagyashri.techblogapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends TechblogappApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Test
    void findByEmail() {
        User user = userRepository.findByEmail("Peter@Marvels.com");
        assertEquals(user.getName(),"Peter Parker");
    }
}