package com.company.quoll.services;

import com.company.quoll.model.SocionicsResult;
import com.company.quoll.repository.SocionicsResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("socionicsResultService")
public class SocionicsResultServiceImpl {

    @Autowired
    private SocionicsResultRepository socionicsResultRepository;

    SocionicsResult findSocionicsResultById(int id) {
        return socionicsResultRepository.findById(id);
    }

}
