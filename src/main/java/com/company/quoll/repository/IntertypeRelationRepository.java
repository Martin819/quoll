package com.company.quoll.repository;


import com.company.quoll.model.IntertypeRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntertypeRelationRepository extends JpaRepository<IntertypeRelation, Integer> {

    IntertypeRelation findById(int id);

    IntertypeRelation findByFitnessOrder(int order);

}
