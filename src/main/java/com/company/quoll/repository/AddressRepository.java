package com.company.quoll.repository;

import com.company.quoll.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findById(int id);

    Address findByNUTS0StartingWith(String NUTS0);

    Address findByNUTS1StartingWith(String NUTS1);

    Address findByNUTS2StartingWith(String NUTS2);

    Address findByNUTS3(String NUTS3);
}
