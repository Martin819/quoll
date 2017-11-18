package com.company.quoll.repository;

import com.company.quoll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByAddress_id(int address_id);

    User findByUsername(String username);

    User findByZodiac_sign(String zodiac_sign);

    User findById(int id);

    User findByDate_of_birth(Date date_of_birth);
}
