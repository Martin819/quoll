package com.company.quoll.services;

import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.repository.IntertypeRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("intertypeRelationService")
public class IntertypeRelationServiceImpl implements IntertypeRelationService {

    @Autowired
    IntertypeRelationRepository intertypeRelationRepository;

    @Override
    public IntertypeRelation findIntertypeRelationById(int id) {
        return intertypeRelationRepository.findById(id);
    }

    @Override
    public IntertypeRelation findIntertypeRelationByFitnessOrder(int order) {
        return intertypeRelationRepository.findByFitnessOrder(order);
    }

}
