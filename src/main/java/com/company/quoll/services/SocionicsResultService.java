package com.company.quoll.services;

import com.company.quoll.model.SocionicsResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SocionicsResultService {

    SocionicsResult findSocionicsResultById(UUID id);
    List<SocionicsResult> findSocionicsResultByExtrovertValueAndSensingValueAndThinkingValueAndPerceivingValue(float E, float S, float T, float p);
    void saveSocionicsResult(SocionicsResult socionicsResult);
}
