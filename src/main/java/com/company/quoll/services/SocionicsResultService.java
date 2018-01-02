package com.company.quoll.services;

import com.company.quoll.model.SocionicsResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SocionicsResultService {

    SocionicsResult findSocionicsResultById(int id);

    List<SocionicsResult> findSocionicsResultByExtrovertValueAndSensingValueAndThinkingValueAndPerceivingValue(float E, float S, float T, float p);

}
