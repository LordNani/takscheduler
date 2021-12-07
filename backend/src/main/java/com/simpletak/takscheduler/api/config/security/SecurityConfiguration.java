package com.simpletak.takscheduler.api.config.security;

import com.simpletak.takscheduler.api.config.security.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    private final JwtFilter jwtFilter;
    private final CookieFilter cookieFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/api/users/sign-in",
                        "/api/test/**",//toRemove
                        "/api/users/sign-up",
                        "/h2-console/**",
                        "/view/**",
                        "/css_js/**",
                        "/webjars/**",
                        "/swagger.html",
                        "/v3/api-docs/**").permitAll()
                .antMatchers("/api/roles/**").hasRole(ADMIN)
                .anyRequest().authenticated()
                .and()
                .requestCache()
                .requestCache(new NullRequestCache())
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(cookieFilter, JwtFilter.class)
                .headers().frameOptions().disable();
    }
}
