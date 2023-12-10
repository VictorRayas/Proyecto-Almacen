package com.example.Almacen.auth;

import com.example.Almacen.auth.filters.JwtAuthenticationFilter;
import com.example.Almacen.auth.filters.JwtValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class SpringSecurityConfig {
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    AuthenticationManager authenticationManager() throws  Exception{
        return  authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/api-almacen/email/").permitAll()
                .antMatchers(HttpMethod.POST,"/api-almacen/email/fallido/").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/user/").permitAll()
                .antMatchers(HttpMethod.POST, "/api-almacen/user/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api-almacen/user/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api-almacen/user/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api-almacen/user/nombre/{nombre}").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/producto/").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/producto/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api-almacen/producto/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api-almacen/producto/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api-almacen/producto/aumento/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api-almacen/producto/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api-almacen/producto/nombre/{nombre}").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/proveedor/").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/proveedor/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api-almacen/proveedor/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api-almacen/proveedor/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api-almacen/proveedor/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/inventario/").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/inventario/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api-almacen/inventario/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api-almacen/inventario/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api-almacen/inventario/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api-almacen/vale/").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/vale/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api-almacen/vale/").permitAll()
                .antMatchers(HttpMethod.GET, "/api-almacen/user/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api-almacen/registro/").permitAll()
                .antMatchers(HttpMethod.POST, "/api-almacen/registro/").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
                .addFilter(new JwtValidationFilter(authenticationConfiguration.getAuthenticationManager()))
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors->cors.configurationSource(corsConfigurationSource()))
                .build();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        config.setAllowedHeaders(Arrays.asList("Authorization","Content-Type"));
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
        return  source;

    }

    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;

    }
}
