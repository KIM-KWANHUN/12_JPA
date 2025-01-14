package com.ohgiraffers.chap100crudtest.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DeptDTO {

    private String deptId;
    private String deptTitle;
    private String locationId;
}
