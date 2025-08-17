package com.mse.devops.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorialApplication.class, args);
    }

//    @Bean
//    public FilterRegistrationBean<JwtFilter> jwtFilter() {
//        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new JwtFilter());
//        registrationBean.addUrlPatterns("/customers");
//
//        return registrationBean;
//    }
}

