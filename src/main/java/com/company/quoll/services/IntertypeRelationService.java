package com.company.quoll.services;

import com.company.quoll.model.IntertypeRelation;
import org.springframework.stereotype.Service;

@Service
public interface IntertypeRelationService {

    IntertypeRelation findIntertypeRelationById(int id);
    IntertypeRelation findIntertypeRelationByFitnessOrder(int order);

}
