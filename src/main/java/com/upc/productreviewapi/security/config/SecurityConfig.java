package com.upc.productreviewapi.security.config;

import com.upc.productreviewapi.security.filters.JwtRequestFilter;
import com.upc.productreviewapi.security.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    //Inyectando JWT Filter por constructor
    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    //se define como un bean para que pueda ser utilizado en otros lugares, como en el controlador de autenticación
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    // Bean para codificar las contraseñas para ser usando en cualquier parte de la app
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //(2) Definir el SecurityFilterChain como un bean, ya no necesitamos heredar, configuramos toda la seg.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // deshabilitar CSRF ya que no es necesario para una API REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                // 🔓 AUTH
                                "/api/dulanto/authenticate",

                                // 🔓 SWAGGER
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/v3/api-docs.yaml",
                                "/swagger-resources/**",
                                "/webjars/**",

                                "/authenticate",
                                "/api/dulanto/",
                                "/api/dulanto/authenticate",
                                "/trujillo/resena",
                                "/api/dulanto/trujillo/resena",
                                "/api/dulanto/trujillo/resenas",
                                "/api/authenticate",      // por si sí lo lleva
                                "/swagger-ui/**",         // Swagger UI
                                "/v3/api-docs/**",        // OpenAPI JSON
                                "/swagger-resources/**",  // internos swagger
                                "/webjars/**"
                        ).permitAll()
                        //.requestMatchers("/api/proveedores").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    //Filter opcional si se desea configurar globalmente el acceso a los endpoints sin anotaciones
    // en cada endpoint
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("${ip.frontend}");
//        config.addAllowedMethod("*");
//        config.addExposedHeader("Authorization");
//        source.registerCorsConfiguration("/**", config); //para todos los paths
//        return new CorsFilter(source);
//    }
}

