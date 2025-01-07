package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section01.entitymanager.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    public EntityManager getManagerInstance() {

        return entityManager;
    }

    public Menu findMenuByCode(int menuCode) {

        entityManager = EntityManagerGenerator.getInstance();

        return entityManager.find(Menu.class, menuCode);
    }
}
