package com.company.quoll.services;

import com.company.quoll.model.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address findAddressById(int id);

    Address findAddressByNuts0StartingWith(String nuts0);

    Address findAddressByNuts1StartingWith(String nuts1);

    Address findAddressByNuts2StartingWith(String nuts2);

    Address findAddressByNuts3(String nuts3);
}
