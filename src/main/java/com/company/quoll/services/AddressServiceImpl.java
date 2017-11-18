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
    public Address findAddressByNuts0StartingWith(String nuts0) {
        return addressRepository.findByNuts0StartingWith(nuts0);
    }

    @Override
    public Address findAddressByNuts1StartingWith(String nuts1) {
        return addressRepository.findByNuts1StartingWith(nuts1);
    }

    @Override
    public Address findAddressByNuts2StartingWith(String nuts2) {
        return addressRepository.findByNuts2StartingWith(nuts2);
    }

    @Override
    public Address findAddressByNuts3(String nuts3) {
        return addressRepository.findByNuts3(nuts3);
    }

    ;
}
