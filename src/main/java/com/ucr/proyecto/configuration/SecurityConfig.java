package com.ucr.proyecto.configuration;


import com.ucr.proyecto.security.FuelControlAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterAfter(new FuelControlAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/h2/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/**/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/**/").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/**/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/**/**").authenticated()
                .and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .formLogin().disable();
    }

}