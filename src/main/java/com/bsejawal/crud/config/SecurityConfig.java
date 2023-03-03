package com.bsejawal.crud.config;

import com.bsejawal.crud.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    JwtFilter jwtFilter;


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        System.out.println("########## at configure auth ##########");
        auth.userDetailsService(userDetailsService);
//        .passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .antMatchers("/db/**").permitAll()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/").permitAll()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable(); // to enable h2 database in browser
        http.headers().frameOptions().disable(); // to enable h2 database in browser
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


    }

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("####### at configure http #######");

        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                ).and();
        http.authorizeRequests()
                        .antMatchers("/").permitAll()
                        .antMatchers("/api/db/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/api/authenticate").permitAll()
                .antMatchers("/admin").hasRole("ROLE_ADMIN")
                        .anyRequest().authenticated();

        http.headers().frameOptions().disable();

    }*/


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                        .antMatchers("/user").hasRole("USER")
//                        .and().formLogin();
//        System.out.println("####### at configure http #######");
//    }

}
