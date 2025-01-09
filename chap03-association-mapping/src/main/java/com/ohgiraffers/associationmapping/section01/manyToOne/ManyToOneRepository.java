package com.ohgiraffers.associationmapping.section01.manyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ManyToOneRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Menu find(int menuCode) {

        return entityManager.find(Menu.class, menuCode);
//        메뉴클래스와 식별자 menuCode 매니저에게 넘기기
    }


    /* text.
    *   JPQL 이란?
    *   - 객체 지향 쿼리 언어 중 하나이다.
    *   - 객체 지향 모델에 맞게 작성된 쿼리를 통해 엔티티를 대상으로 검색을 진행하며, 세밀한 조작을 할 수 있다는 장정이 있다.
    *   - 단, 주의점은 테이블에서 조회하는 것이 아닌 엔티티를 통해 조회하는 것이기 때문에
    *   - FROM 절에는 테이블명이 아닌, 엔티티명으로 해야한다. */
    public String findCategoryName(int menuCode) {

        String jpql = "SELECT c.categoryName " +
                      "FROM menu_and_category m " +
                      "JOIN m.category c " +
                      "WHERE m.menuCode = :menuCode";

        return entityManager.createQuery(jpql, String.class)
                .setParameter("menuCode", menuCode)
                .getSingleResult(); // 결과가 1개

    }

    public void registMenu(Menu menu1) {

        entityManager.persist(menu1);
    }
}
