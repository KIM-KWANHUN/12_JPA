package com.ohgiraffers.crudtest.Model.DAO;

import com.ohgiraffers.crudtest.Model.DTO.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
