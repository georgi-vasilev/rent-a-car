package com.group.carrentalserver.config;

import com.group.carrentalserver.security.AuthenticationEntryPoint;
import com.group.carrentalserver.security.filter.AuthenticationFilter;
import com.group.carrentalserver.security.filter.AuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final AuthenticationConfiguration authenticationConfiguration;

    public SecurityConfig(AuthenticationEntryPoint authenticationEntryPoint,
                          AuthenticationConfiguration authenticationConfiguration) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationConfiguration = authenticationConfiguration;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable();

        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .addFilter(new AuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
                .addFilterAfter(new AuthorizationFilter(), AuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico").permitAll()
                .antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .antMatchers("/sign-up/**").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin().loginPage("/login").permitAll();

        http
                .logout().logoutUrl("/logout").permitAll()
                .deleteCookies("JSESSIONID");

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*");
            }
        };
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
