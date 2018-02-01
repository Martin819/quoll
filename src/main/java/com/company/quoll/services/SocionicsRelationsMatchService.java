package com.company.quoll.services;

import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SocionicsRelationsMatchService {

    SocionicsRelationsMatch findSocionicsRelationsMatchById(int id);

    List<SocionicsRelationsMatch> findSocionicsRelationsMatchByTypeAAndIntertypeRelation(
            String typeA, IntertypeRelation intertypeRelation);

    SocionicsRelationsMatch findSocionicsRelationsMatch(String typeA, String typeB);

}
