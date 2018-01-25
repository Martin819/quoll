package com.company.quoll.repository;

import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocionicsRelationsMatchRepository extends JpaRepository<SocionicsRelationsMatch, Integer> {

    SocionicsRelationsMatch findById(int id);
    SocionicsRelationsMatch findByTypeAAndIntertypeRelation(String typeA, IntertypeRelation intertypeRelation);

}
