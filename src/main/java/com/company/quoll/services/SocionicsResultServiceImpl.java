package com.company.quoll.services;

import com.company.quoll.model.SocionicsResult;
import com.company.quoll.repository.SocionicsResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("socionicsResultService")
public class SocionicsResultServiceImpl implements SocionicsResultService {

    @Autowired
    private SocionicsResultRepository socionicsResultRepository;

    @Override
    public SocionicsResult findSocionicsResult(UUID id) {
        return socionicsResultRepository.findById(id);
    }

    @Override
    public List<SocionicsResult> findSocionicsResult(float E, float S, float T, float p) {
        return socionicsResultRepository.findByExtrovertValueAndSensingValueAndThinkingValueAndPerceivingValue(E, S, T, p);
    }

    @Override
    public void save(SocionicsResult socionicsResult) {
        socionicsResultRepository.save(socionicsResult);
    }

}
