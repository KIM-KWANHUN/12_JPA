package com.ohgiraffers.chap100crudtest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "department")
public class Dept {

    @Id
    @Column(name = "dept_id")
    private String deptId;

    @Column(name = "dept_title")
    private String deptTitle;

    @Column(name = "location_id")
    private String locationId;
}
