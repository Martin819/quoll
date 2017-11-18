package com.company.quoll.services;

import com.company.quoll.model.SocionicsResult;
import org.springframework.stereotype.Service;

@Service
public interface SocionicsResultService {
    SocionicsResult findSocionicsResultById(int id);
}
