package com.ohgiraffers.associationmapping.section02.oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OneToManyRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Category findCategory(int categoryCode) {

        return entityManager.find(Category.class, categoryCode);
    }
}
