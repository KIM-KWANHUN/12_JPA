package com.ohgiraffers.springdatajpa.Menu.model.dao;

import com.ohgiraffers.springdatajpa.Menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /* text. 직접 쿼리문을 작성해보기 */
    @Query(value = "SELECT * FROM TBL_CATEGORY ORDER BY CATEGORY_CODE", nativeQuery = true)
    List<Category> findAllCategory();
}