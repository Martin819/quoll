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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findUserByAddress(Address address) {
        return userRepository.findByAddress(address);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findUserByZodiacSign(Integer zodiacSign) {
        return userRepository.findByZodiacSign(zodiacSign);
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findUserByDateOfBirth(Date dateOfBirth) {
        return userRepository.findByDateOfBirth(dateOfBirth);
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
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        user.setZodiacSign(ZodiacSigns.getZodiacSign(user.getDateOfBirth()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void addSocionicsTypeToUser(User user) {
        user.setSocionicsType(SocionicsTypes.getTypeCode(user.getSocionicsResult()));
    }

    @Override
    public List<User> getMatchedUsersByFitnessOrder(User user, int fitnessOrder) {
        String userType = user.getSocionicsType();
        IntertypeRelation intertypeRelation = intertypeRelationService.findIntertypeRelationByFitnessOrder(fitnessOrder);
        System.out.println(intertypeRelation.getName());
        List<SocionicsRelationsMatch> relationsMatches = socionicsRelationsMatchService.findSocionicsRelationsMatchByTypeAAndIntertypeRelation(userType, intertypeRelation);
        List<User> matchedUsers = new ArrayList<>();
        for (SocionicsRelationsMatch srm:relationsMatches) {
            String matchType = srm.getTypeB();
            List<User> typeUsers = this.findUserBySocionicsType(matchType);
            matchedUsers.addAll(typeUsers);
        }
        return matchedUsers;
    }
}
