package com.company.quoll.services;

import com.company.quoll.model.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address findAddressById(int id);

    Address findAddressByNUTS0StartingWith(String NUTS0);

    Address findAddressByNUTS1StartingWith(String NUTS1);

    Address findAddressByNUTS2StartingWith(String NUTS2);

    Address findAddressByNUTS3(String NUTS3);
}
