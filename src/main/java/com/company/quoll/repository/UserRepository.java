package com.company.quoll.repository;

import com.company.quoll.model.Address;
import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByAddress(Address address);

    User findByUsername(String username);

    List<User> findByZodiacSign(Integer zodiacSign);

    User findById(int id);

    List<User> findByDateOfBirth(Date dateOfBirth);

    List<User> findBySocionicsType(String socionicsType);
}
