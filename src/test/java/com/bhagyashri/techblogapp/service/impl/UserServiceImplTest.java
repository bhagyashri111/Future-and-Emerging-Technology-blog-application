package com.bhagyashri.techblogapp.service.impl;

import com.bhagyashri.techblogapp.TechblogappApplicationTests;
import com.bhagyashri.techblogapp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest extends TechblogappApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    void findByEmail() {
        User user = userService.findByEmail("peter@marvels.com");
        assertEquals("Peter Parker", user.getName());
    }
}