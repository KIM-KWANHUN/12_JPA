package com.ohgiraffers.associationmapping.section02.oneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OneToManyService {

    @Autowired
    private OneToManyRepository oneToManyRepository;

    /* comment.
     *   DML 구문을 사용할 때 @Transactional 어노테이션을 사용하는데
     *   이번에는 조회임에도 불구하고 사용하는 이유는
     *   EX) 10번 카테고리를 갖는 메뉴가 10개면 SELECT 를 10번을 해줘야 한다.
     *   1개의 엔티티가 여러 개의 엔티티를 로드 해야 하는 상황은
     *   성능상의 이슈가 발생할 수 있다.
     *   따라서 일단 카테고리만 조회 후 필요 시에 로드를 하게 된다.
     *   @OneToMany(fetch = FetchType.LAZY)
     *   지연 로딩 이라고 하는 것인데 카테고리 조회시 연관 된 메뉴들은
     *   부르기 전까지 조회하지 않고 부를 때 로딩을 하는 것이다.
     *   1개의 엔티티를 조회할 때 1개만 조회하면 되므로 즉시로딩(이른 로딩)
     *   이 디폴트 값이다. */

    @Transactional(readOnly = true)
    public Category findCategory(int categoryCode) {

        Category category = oneToManyRepository.findCategory(categoryCode);

        System.out.println("category = " + category);

        return category;
    }
}
