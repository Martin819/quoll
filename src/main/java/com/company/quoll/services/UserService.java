package com.company.quoll.services;


import com.company.quoll.model.Address;
import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface UserService {

    User findUserById(int id);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    List<User> findUserBySocionicsType(String socionicsType);
    List<User> findAll();
    List<User> removeForeignMatchedUsers(List<User> matchedUsers, String userAddressCode);
    List<User> removeMatchedUsersBySex(List<User> matchedUsers, String sex);
    List<User> removeYoungMatchedUsers(List<User> matchedUsers, Integer ageMin);
    List<User> removeOldMatchedUsers(List<User> matchedUsers, Integer ageMax);
    List<User> getMatchedUsersByFitnessOrder(User user, int fitnessOrder, String onlyMyCountry,
                                             String men, String women, Integer ageMin, Integer ageMax);
    void save(User user);
    void update(User user);

}
