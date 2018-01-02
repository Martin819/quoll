package com.company.quoll.services;


import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import com.company.quoll.repository.SocionicsRelationsMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("socionicsRelationsMatchService")
public class SocionicsRelationsMatchServiceImpl implements SocionicsRelationsMatchService {

    @Autowired
    SocionicsRelationsMatchRepository socionicsRelationsMatchRepository;

    @Override
    public SocionicsRelationsMatch findSocionicsRelationsMatchById(int id){
        return socionicsRelationsMatchRepository.findById(id);
    }

    @Override
    public SocionicsRelationsMatch findSocionicsRelationsMatchByTypeAAndAndIntertypeRelation(String typeA,
                                                                                             IntertypeRelation
                                                                                                    intertypeRelation){
        return socionicsRelationsMatchRepository.findByTypeAAndAndIntertypeRelation(typeA,intertypeRelation);
    }

}
