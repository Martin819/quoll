package com.company.quoll.services;


import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import com.company.quoll.repository.SocionicsRelationsMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("socionicsRelationsMatchService")
public class SocionicsRelationsMatchServiceImpl implements SocionicsRelationsMatchService {

    @Autowired
    SocionicsRelationsMatchRepository socionicsRelationsMatchRepository;

    @Override
    public SocionicsRelationsMatch findSocionicsRelationsMatchById(int id) {
        return socionicsRelationsMatchRepository.findById(id);
    }

    @Override
    public List<SocionicsRelationsMatch> findSocionicsRelationsMatchByTypeAAndIntertypeRelation(
            String typeA, IntertypeRelation intertypeRelation) {
        return socionicsRelationsMatchRepository.findByTypeAAndIntertypeRelation(typeA, intertypeRelation);
    }

    @Override
    public SocionicsRelationsMatch findSocionicsRelationsMatch(String typeA, String typeB) {
        return socionicsRelationsMatchRepository.findFirstByTypeAEqualsAndTypeBEquals(typeA, typeB);
    }

}
