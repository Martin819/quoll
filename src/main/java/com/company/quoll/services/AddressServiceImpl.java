package com.company.quoll.services;

import com.company.quoll.model.Address;
import com.company.quoll.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findAddressById(String id) {
        return addressRepository.findAddressByIdEquals(id);
    }

    @Override
    public List<Address> findAddresses(String name, int nutsLevel) {
        if (name == null) {
            return addressRepository.findAddressesByNutsLevelEquals(nutsLevel);
        } else {
            return addressRepository.findAddressesByNutsLevelEqualsAndIdStartingWith(nutsLevel, name);
        }
    }

}
