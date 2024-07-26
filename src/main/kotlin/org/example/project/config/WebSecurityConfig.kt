package org.example.project.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter
import org.springframework.security.web.SecurityFilterChain
import java.util.stream.Stream

@Configuration
@EnableWebSecurity
class WebSecurityConfig {
    @Bean
    fun securityFilterChain(http:HttpSecurity):SecurityFilterChain{

        http
            .authorizeHttpRequests{
                it.requestMatchers("/api/v1/student/findAll").hasRole("STUDENT")
                it.anyRequest().authenticated()


            }
            .oauth2ResourceServer{
                it.jwt(Customizer.withDefaults())
            }
            .csrf().disable()

        return http.build()
    }

    @Bean
    fun jwtAuthenticationConverter():JwtAuthenticationConverter{
        val jwtGrantedAuthoritiesConverter = JwtGrantedAuthoritiesConverter()
        val converter = JwtAuthenticationConverter()
        converter.setPrincipalClaimName("preferred name")
        converter.setJwtGrantedAuthoritiesConverter{jwt ->
            val authorities = jwtGrantedAuthoritiesConverter.convert(jwt)
            val roles = jwt.getClaimAsMap("realm_access")["roles"] as List<String>
            authorities?.stream()?.let {
                Stream.concat(
                    it,
                    roles.stream()
                        .filter{it.startsWith("ROLE_")}
                        .map { SimpleGrantedAuthority(it) }
                ).toList()
            }
        }
        return converter

    }
}