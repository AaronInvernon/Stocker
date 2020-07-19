package com.ironhack.EdgeService.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecurityConfiguration {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SalesRepService salesRepService;

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(salesRepService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests()
                //SalesRep controller
                .mvcMatchers(HttpMethod.GET, "/salesreps").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST, "/salesreps").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/salesreps/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/salesreps/{id}").hasAuthority("ROLE_ADMIN")
}
