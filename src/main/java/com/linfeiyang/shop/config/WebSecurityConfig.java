package com.linfeiyang.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomAuthenticationManager customAuthenticationManager;

    @Resource
    private CustomAuthenticationFilter customAuthenticationFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.parentAuthenticationManager(customAuthenticationManager);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)).and().addFilter(customAuthenticationFilter)
                .authorizeRequests()
                .antMatchers("/login").permitAll() //2
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login") //注1
                .permitAll();
        http.csrf().disable();
        http.logout().logoutUrl("/logout").logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }
}
