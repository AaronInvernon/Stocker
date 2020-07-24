package com.ironhack.EdgeService.security;

import com.ironhack.EdgeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeService employeeService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(employeeService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests()
                //Employees controller
                .mvcMatchers(HttpMethod.GET, "/employees/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                //Bill controller
                .mvcMatchers(HttpMethod.POST, "/bills").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/bills").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/bills/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/bills/client/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                //Client controller
                .mvcMatchers(HttpMethod.POST, "/clients").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/clients").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/clients/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                //Order controller
                .mvcMatchers(HttpMethod.POST, "/orders").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/orders").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/orders/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/orders/client/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/orders/employee/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                //Product controller
                .mvcMatchers(HttpMethod.POST, "/products").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/products").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.GET, "/products/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.DELETE, "/products/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .mvcMatchers(HttpMethod.PATCH, "/products/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_SALES")
                .anyRequest().permitAll()
                .and().requestCache().requestCache(new NullRequestCache())
                .and().logout().deleteCookies("JSESSIONID");
    }
}
