package com.pinway.gatewayserver.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Configuration
public class WebSecurityConfig {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecurityContextRepository securityContextRepository;

    @Bean
    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
        http
                .exceptionHandling()
                .authenticationEntryPoint((swe, e) ->
                        Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED))
                ).accessDeniedHandler((swe, e) ->
                        Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN))
                ).and()
                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()
                .csrf(csrf -> csrf.disable())
                .formLogin().disable()
                .httpBasic().disable()
                .authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository)
                .authorizeExchange()
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .pathMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                .pathMatchers( HttpMethod.POST, "/api/signin/login", "/api/signin/refresh-token").permitAll()
                .pathMatchers(HttpMethod.POST, "/api/user/**").hasAuthority("ROLE_ADMINISTRATOR")
                .pathMatchers(HttpMethod.DELETE, "/api/user/**").hasAuthority("ROLE_ADMINISTRATOR")
                .pathMatchers(HttpMethod.PUT, "/api/user/**").hasAuthority("ROLE_ADMINISTRATOR")
                .pathMatchers("/api/role/**").hasAuthority("ROLE_ADMINISTRATOR")
                .pathMatchers("/api/post/**", "api/notifications/**", "/api/collections/**", "/api/hashtag/**", "/api/comments/**", "/api/like/**" ).hasAuthority("ROLE_USER")
                .anyExchange().authenticated()
                .and();

        return http.build();
    }
}