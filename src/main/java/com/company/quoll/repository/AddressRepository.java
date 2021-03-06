package com.company.quoll.repository;

import com.company.quoll.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressByIdEquals(String id);

    List<Address> findAddressesByNutsLevelEqualsAndIdStartingWith(int nutsLevel, String name);

    List<Address> findAddressesByNutsLevelEquals(int nutsLevel);

}
