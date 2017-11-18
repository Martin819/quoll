package com.company.quoll.repository;

import com.company.quoll.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("addressRepository")
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findById(int id);

    Address findByNuts0StartingWith(String nuts0);

    Address findByNuts1StartingWith(String nuts1);

    Address findByNuts2StartingWith(String nuts2);

    Address findByNuts3(String nuts3);
}
