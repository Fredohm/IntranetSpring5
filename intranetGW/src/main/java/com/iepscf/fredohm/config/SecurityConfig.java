package com.iepscf.fredohm.config;

import com.iepscf.fredohm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /* @ListOfPaths
        // ===> ALL
          /home
          /meeting-room/list
          /meeting-room/display

          // ===> ADMIN
          /meeting-room/add
          /meeting-room/save
          /meeting-room/update
          /meeting-room/delete

          /user/*

         */
        http.authorizeRequests()
                .antMatchers("/home", "/meeting-room/list", "/meeting-room/display").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .antMatchers("/meeting-room/add", "/meeting-room/save", "/meeting-room/update", "/meeting-room/delete", "/user/**").hasRole("ADMIN")
                .and()
                    .formLogin()
                        .loginPage("/login-page")
                        .loginProcessingUrl("/authenticate-user")
                        .successHandler(customAuthenticationSuccessHandler)
                        .permitAll()
                        .and()
                            .logout()
                            .permitAll()
                                .and()
                                    .exceptionHandling().accessDeniedPage("/access-denied");

    }

    // bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // authenticationProvide bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return  authenticationProvider;
    }
}
