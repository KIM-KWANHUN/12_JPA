package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EntityManagerGeneratorTest {

    /* title. Persistence Context 를 이해하기 위한 엔티티 매니저와 팩토리 */

    /* comment.
    *   엔티티 매니저 팩토리란?
    *   엔티티 매니저를 생성할 수 있는 기능을 제공하는 클래스이다.
    *   팩토리는 thread 에 안전하기 때문에(동시성) 하나의 인스턴스를
    *   생성해서 application 스코프와 동일하게 관리한다. == singleTon */

    @Test @DisplayName("엔티티 매니저 팩토리 생성 확인하기")
    void testCreateFactory() {

        EntityManagerFactory factory =
                EntityManagerFactoryGenerator.getInstance();

        EntityManagerFactory factory2 =
                EntityManagerFactoryGenerator.getInstance();

        System.out.println("factory 가 싱글톤인지 확인용 = " + factory.hashCode());
        System.out.println("factory2 가 싱글톤인지 확인용 = " + factory2.hashCode());

        // 팩토리가 잘 생성됫는지 확인
        Assertions.assertNotNull(factory);

        // 팩토리가 싱글톤인지 확인 한 결과 팩토리는 하나이다.
        Assertions.assertEquals(factory, factory2);

    }

    /* comment.
    *   엔티티 매니저란?
    *   엔티티 매니저는 엔티티를 저장하는 메모리 상의 DB 를 관리하는
    *   인스턴스이다.
    *   저장, 수정, 삭제, 조회 등의 엔티티 관련 모든 일을 factory 내부에서
    *   진행하게 된다.
    *   엔티티 매니저는 동시성에 안전핮지 못 하기 때문에
    *   1개의 요청 시 매니저를 생성하게 한다. (request-scope) 와 일치 */

    @Test @DisplayName("엔티티 매니저 생성 확인")
    void testCreateManager() {
        // factory 일하는 매니저 생성1
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        // factory 일하는 매니저 생성2
        EntityManager entityManager2 = EntityManagerGenerator.getInstance();

        System.out.println("매니저가 싱글톤인지확인1 = " + entityManager.hashCode());
        System.out.println("매니저가 싱글톤인지확인2 = " + entityManager2.hashCode());
        // 위에 둘은 다른 것 을 확인했다. 쓸때마다 생성해서 사용하면 된다.

        // 매니저1 이 생성 되는지 확인
        Assertions.assertNotNull(entityManager);
        // 매니저2 이 생성 되는지 확인
        Assertions.assertNotNull(entityManager2);

        // 둘이 같지 않으면 true 가 나오면서 테스트 통과
        Assertions.assertNotEquals(entityManager, entityManager2);
    }

}
