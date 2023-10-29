package com.chuwa.redbookblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;


@Configuration
public class CommonConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
