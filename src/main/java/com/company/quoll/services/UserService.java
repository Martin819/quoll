package com.company.quoll.services;


import com.company.quoll.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface UserService {
    User findUserByEmail(String email);

    User findUserByUsername(String username);

    User findUserByAddress(int address);

    User findUserByZodiacSign(String zodiacSign);

    User findUserById(int id);

    User findUserByDateOfBirth(Date dateOfBirth);

    void saveUser(User user);
}
