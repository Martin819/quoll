package com.company.quoll.services;

import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import org.springframework.stereotype.Service;

@Service
public interface SocionicsRelationsMatchService {

    SocionicsRelationsMatch findSocionicsRelationsMatchById(int id);
    SocionicsRelationsMatch findSocionicsRelationsMatchByTypeAAndIntertypeRelation(String typeA,
                                                                                      IntertypeRelation
                                                                                                 intertypeRelation);
}
