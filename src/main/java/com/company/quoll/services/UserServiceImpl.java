package com.company.quoll.services;

import com.company.quoll.model.Address;
import com.company.quoll.model.Role;
import com.company.quoll.model.User;
import com.company.quoll.repository.RoleRepository;
import com.company.quoll.repository.UserRepository;
import com.company.quoll.utils.SocionicsTypes;
import com.company.quoll.utils.ZodiacSigns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

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

}
