package com.company.quoll.services;

import com.company.quoll.model.*;
import com.company.quoll.repository.RoleRepository;
import com.company.quoll.repository.UserRepository;
import com.company.quoll.utils.SocionicsTypes;
import com.company.quoll.utils.ZodiacSigns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private IntertypeRelationService intertypeRelationService;

    @Autowired
    private SocionicsRelationsMatchService socionicsRelationsMatchService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findUserBySocionicsType(String socionicsType) {
        return userRepository.findBySocionicsType(socionicsType);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setZodiacSign(ZodiacSigns.getZodiacSign(user.getDateOfBirth()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> removeForeignMatchedUsers(List<User> matchedUsers, String userAddressCode) {
        matchedUsers.removeIf(u -> !u.getAddress().getCountryCode().equals(userAddressCode));
        return matchedUsers;
    }

    @Override
    public List<User> removeMatchedUsersBySex(List<User> matchedUsers, String sex) {
        matchedUsers.removeIf(u -> u.getSex().equals(sex));
        return matchedUsers;
    }

    @Override
    public List<User> removeYoungMatchedUsers(List<User> matchedUsers, Integer ageMin) {
        for (Iterator<User> it = matchedUsers.iterator(); it.hasNext();) {
            User u = it.next();
            int age = ZodiacSigns.getAge(u.getDateOfBirth());
            if (age < ageMin) {
                it.remove();
            }
        }
        return matchedUsers;
    }

    @Override
    public List<User> removeOldMatchedUsers(List<User> matchedUsers, Integer ageMax) {
        for (Iterator<User> it = matchedUsers.iterator(); it.hasNext();) {
            User u = it.next();
            int age = ZodiacSigns.getAge(u.getDateOfBirth());
            if (age > ageMax) {
                it.remove();
            }
        }
        return matchedUsers;
    }

    @Override
    public List<User> getMatchedUsersByFitnessOrder(User user, int fitnessOrder, String onlyMyCountry, String men, String women, Integer ageMin, Integer ageMax) {
        String userType = user.getSocionicsType();
        IntertypeRelation intertypeRelation = intertypeRelationService
                .findIntertypeRelationByFitnessOrder(fitnessOrder);
        System.out.println(intertypeRelation.getName());
        List<SocionicsRelationsMatch> relationsMatches = socionicsRelationsMatchService
                .findSocionicsRelationsMatchByTypeAAndIntertypeRelation(userType, intertypeRelation);
        List<User> matchedUsers = new ArrayList<>();
        for (SocionicsRelationsMatch srm:relationsMatches) {
            String matchType = srm.getTypeB();
            List<User> typeUsers = this.findUserBySocionicsType(matchType);
            matchedUsers.addAll(typeUsers);
            System.out.println(onlyMyCountry);
            System.out.println(men);
            System.out.println(women);
            System.out.println("All Users: " + matchedUsers);
            if (onlyMyCountry != null) {
                System.out.println("--- Removing Foreign Users ---");
                System.out.println(user.getAddress().getId());
                matchedUsers = removeForeignMatchedUsers(matchedUsers, user.getAddress().getCountryCode());
            }
            System.out.println("After country: " + matchedUsers);
            if (men == null) {
                System.out.println("--- Removing Male Users ---");
                matchedUsers = removeMatchedUsersBySex(matchedUsers, "Male");
            }
            System.out.println("After Male: " + matchedUsers);
            if (women == null) {
                System.out.println("--- Removing Female Users ---");
                matchedUsers = removeMatchedUsersBySex(matchedUsers, "Female");
            }
            System.out.println("After Female: " + matchedUsers);
            if (ageMin != null) {
                System.out.println("--- Removing Young Users ---");
                matchedUsers = removeYoungMatchedUsers(matchedUsers, ageMin);
            }
            System.out.println("After ageMin: " + matchedUsers);
            if (ageMax != null) {
                System.out.println("--- Removing Old Users ---");
                matchedUsers = removeOldMatchedUsers(matchedUsers, ageMax);
            }
            System.out.println("After ageMax: " + matchedUsers);
        }
        return matchedUsers;
    }
}
