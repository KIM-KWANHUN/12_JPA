package com.ohgiraffers.crudtest.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

       modelMapper.getConfiguration().setFieldAccessLevel(
               org.modelmapper.config.Configuration.AccessLevel.PRIVATE
       ).setFieldMatchingEnabled(true);

        return modelMapper;
    }
}
