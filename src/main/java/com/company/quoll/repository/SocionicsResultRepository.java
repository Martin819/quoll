package com.company.quoll.repository;

import com.company.quoll.model.SocionicsResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SocionicsResultRepository extends JpaRepository<SocionicsResult, Integer> {

    SocionicsResult findById(UUID id);

    List<SocionicsResult> findByExtrovertValueAndSensingValueAndThinkingValueAndPerceivingValue(float E, float S, float T, float p);

}
