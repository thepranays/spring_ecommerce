package com.dreamfist.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity //As spring cloud gateway is based on spring web-flux not spring web-mvc
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain springSecurityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
        serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable)//As we are just using postman for now
                .authorizeExchange(authorizeExchangeSpec -> //Adding exchange information i.e. how web flux should handle the security
                        authorizeExchangeSpec.pathMatchers("/eureka/**").permitAll() //We don't want any security layer for /eureka/** as we are accessing static files there
                                .anyExchange().authenticated() //Apart from above we want all path calls to be authenticated
                )
//                .headers(headerSpec -> headerSpec.)
                .oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec.jwt(Customizer.withDefaults())); //Enabling use of oauth 2 resource server with jwt


        return serverHttpSecurity.build();

    }
}
