package com.bhagyashri.techblogapp.service;

import com.bhagyashri.techblogapp.dto.RegistrationDto;
import com.bhagyashri.techblogapp.entity.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}
