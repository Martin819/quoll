package com.company.quoll.repository;

import com.company.quoll.model.Address;
import com.company.quoll.model.SocionicsResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("socionicsResultRepository")
public interface SocionicsResultRepository extends JpaRepository<Address, Integer> {

    SocionicsResult findById(int id);

}
