package com.ohgiraffers.springdatajpa.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.springdatajpa")
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        /* comment.
        *   entity 클래스는 데이터의 무결성을 유지하기 위해
        *   setter 사용을 지양한다.
        *   그렇다면 dto 값을 어떻게 entity 에 넣을 수 있는 방법을 찾아야 한다.
        *   modelMapper 는 dto <-> entity 간 변환을 용이하게 하는 라이브러리이다.
        *   */

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);

            return modelMapper;
    }





}
