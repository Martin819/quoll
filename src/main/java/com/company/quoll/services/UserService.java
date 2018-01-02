package com.company.quoll.services;


import com.company.quoll.model.Address;
import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface UserService {
    User findUserByEmail(String email);

    User findUserByUsername(String username);

    List<User> findUserByAddress(Address address);

    List<User> findUserByZodiacSign(int zodiacSign);

    User findUserById(int id);

    List<User> findUserByDateOfBirth(Date dateOfBirth);

    List<User> findUserBySocionicsType(String socionicsType);

    void saveUser(User user);

    void addSocionicsTypeToUser(User user);
}
