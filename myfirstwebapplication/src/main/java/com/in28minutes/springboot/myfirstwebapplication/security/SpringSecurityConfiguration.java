package com.in28minutes.springboot.myfirstwebapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
    //Using InMemeory Manager
    //InMemoryUserDetailsManager
    //Currently we use withDefaultPasswordEncoder which is deprecated, we will replace that with encoder later

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = User.withDefaultPasswordEncoder().username("aravind").password("password").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(userDetails);
    }

}
