package com.pinkstack.config;

import com.pinkstack.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class BeanConfig {

    @Bean
    public InternalResourceViewResolver setupViewResolver()  {
        InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
        resolver.setPrefix ("/ui/jsp/");
        resolver.setSuffix (".jsp");
        resolver.setViewClass (JstlView.class);
        return resolver;
    }

    @Bean
    public User powerPuffUser() {
        User user = new User();
        user.setId(0);
        user.setEmail("admin@gmail.com");
        user.setName("admin");
        user.setPassword("admin");
        return user;
    }
}
