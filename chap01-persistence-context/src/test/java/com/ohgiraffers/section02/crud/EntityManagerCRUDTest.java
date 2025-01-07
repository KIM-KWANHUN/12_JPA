package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EntityManagerCRUDTest {

    /* comment.
    *   Test 클래스는 기존 Main 영역의 메소드를 테스트 하기 위함이다.
    *   따라서 검증할 클래스의 인스턴스를 생성해서 테스트 하는 용도로 사용이 된다. */
    private EntityManagerCRUD entityManagerCRUD;

    @BeforeEach
    void initManager() {
        // 테스트 메소드 실행 전 crud 클래스 인스턴스 생성
        this.entityManagerCRUD = new EntityManagerCRUD();
    }

    @AfterEach
    void rollback() {
        // 테스트가 실제 DB 에 반영되지 않게 rollback 설정
        EntityTransaction transaction
                = entityManagerCRUD.getManagerInstance().getTransaction();

        // 모든 권한은 매니저에게 entity 를 관리하게 넘겨준다.
        transaction.rollback();
    }
    /* comment.
        테스트 시 여러 값들을 이용해서 검증이 필요한 경우 경우의 수 별로 테스트 메소드를 작성해야 한다.
        parameterizedTest 는 경우의 수 만큼 반복해야 할 작업을 줄여줄 수 있다.
        파라미터로 전달한 값을 목록 만큼 반복적으로 테스트 메소드를 실행해준다.*/

    @ParameterizedTest
    // 여러개의 테스트 전용 파라미터를 전달. 쉼표로 구분할 수 있다.
    @CsvSource({"1,1", "2,2", "3,3"})
    void testFindByCode(int menuCode, int expected) {
        Menu foundMenu = entityManagerCRUD.findMenuByCode(menuCode);

        Assertions.assertEquals(expected, foundMenu.getMenuCode());


    }
}
