package com.company.quoll.repository;

import com.company.quoll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByAddress(int address);

    User findByUsername(String username);

    User findByZodiacSign(String zodiacSign);

    User findById(int id);

    User findByDateOfBirth(Date dateOfBirth);
}
