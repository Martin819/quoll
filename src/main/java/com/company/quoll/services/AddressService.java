package com.company.quoll.services;

import com.company.quoll.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address findAddressById(String id);
    List<Address> findAddresses(String name, int nutsLevel);

}
