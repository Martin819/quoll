package com.company.quoll.services;

import com.company.quoll.model.Address;
import com.company.quoll.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findAddressById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address findAddressByNUTS0StartingWith(String NUTS0) {
        return addressRepository.findByNUTS0StartingWith(NUTS0);
    }

    @Override
    public Address findAddressByNUTS1StartingWith(String NUTS1) {
        return addressRepository.findByNUTS1StartingWith(NUTS1);
    }

    @Override
    public Address findAddressByNUTS2StartingWith(String NUTS2) {
        return addressRepository.findByNUTS2StartingWith(NUTS2);
    }

    @Override
    public Address findAddressByNUTS3(String NUTS3) {
        return addressRepository.findByNUTS3(NUTS3);
    }

    ;
}
