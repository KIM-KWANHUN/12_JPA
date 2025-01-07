package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section01.entitymanager.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    public EntityManager getManagerInstance() {

        return entityManager;
    }

    // parameter 로 받아서 메뉴조회
    public Menu findMenuByCode(int menuCode) {

        entityManager = EntityManagerGenerator.getInstance();

        return entityManager.find(Menu.class, menuCode);
    }

    // 메뉴 추가
    public Long saveAndReturnCount(Menu menu) {

        entityManager = EntityManagerGenerator.getInstance();
        // 트랙잭션
        EntityTransaction entityTransaction = entityManager.getTransaction();
        // 트랙잭션 시작
        entityTransaction.begin();

        entityManager.persist(menu);

        // DB에 반영을 요청
        entityManager.flush();

        entityTransaction.commit();

        return getCount(entityManager);
    }

    private Long getCount(EntityManager entityManager) {

        // createQuery 쿼리문 직접 작성하는 구문
        return entityManager.createQuery("SELECT COUNT(*) FROM section02Menu", Long.class).getSingleResult();
    }

    // 메뉴 수정
    public Menu modifyMenu(int code, String name) {

        Menu menu = findMenuByCode(code);

        System.out.println("코드로 메뉴조회가 잘되는지 확인용 = " + menu);

        // 추가, 수정, 삭제는 트랜잭션을 해주어야함
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        menu.setMenuName(name);

        transaction.commit();

        return menu;
    }

    // 메뉴삭제
    public Long removeAndReturnCount(int code) {

        // 메뉴를 특정하기 위해 code 를 쓴다.
        Menu menu = findMenuByCode(code);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(menu);

        transaction.commit();

        return getCount(entityManager);
    }
}
