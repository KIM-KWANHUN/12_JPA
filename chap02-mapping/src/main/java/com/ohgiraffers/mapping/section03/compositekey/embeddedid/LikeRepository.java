package com.ohgiraffers.mapping.section03.compositekey.embeddedid;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeRepository {


    @PersistenceContext
    private EntityManager entityManager;


    public void save(Like likeDTO1) {

        entityManager.persist(likeDTO1);
    }
}
