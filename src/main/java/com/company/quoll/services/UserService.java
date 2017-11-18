package com.company.quoll.services;


import com.company.quoll.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface UserService {
    User findUserByEmail(String email);

    User findUserByUsername(String username);

    User findUserByAddress_id(int address_id);

    User findUserByZodiac_sign(String zodiac_sign);

    User findUserById(int id);

    User findUserByDate_of_birth(Date date_of_birth);

    void saveUser(User user);
}
