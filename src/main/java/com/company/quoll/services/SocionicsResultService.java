package com.company.quoll.services;

import com.company.quoll.model.SocionicsResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SocionicsResultService {

    SocionicsResult findSocionicsResult(UUID id);

    List<SocionicsResult> findSocionicsResult(float E, float S, float T, float p);

    void save(SocionicsResult socionicsResult);

}
