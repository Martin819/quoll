package com.company.quoll.repository;

import com.company.quoll.model.IntertypeRelation;
import com.company.quoll.model.SocionicsRelationsMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocionicsRelationsMatchRepository extends JpaRepository<SocionicsRelationsMatch, Integer> {

    SocionicsRelationsMatch findById(int id);

    SocionicsRelationsMatch findFirstByTypeAEqualsAndTypeBEquals(String typeA, String typeB);

    List<SocionicsRelationsMatch> findByTypeAAndIntertypeRelation(String typeA, IntertypeRelation intertypeRelation);

}
