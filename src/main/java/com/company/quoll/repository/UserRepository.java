package com.company.quoll.repository;

import com.company.quoll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(int id);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findBySocionicsType(String socionicsType);

}
