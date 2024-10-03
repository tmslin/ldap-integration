package org.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig
{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorize ->
            {
                authorize.anyRequest().permitAll();
            })
            .formLogin(Customizer.withDefaults());


//        http
//            .authorizeHttpRequests((authorize) ->
//            {
//                authorize.anyRequest().fullyAuthenticated();
//            })
//            .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
//        auth
//            .ldapAuthentication()
//            .userDnPatterns("cn={0},dc=example,dc=org")
//            .contextSource()
//            .url("ldap://localhost:389/")
//            .and()
//            .passwordCompare()
//            .passwordEncoder(new LdapShaPasswordEncoder())
//            .passwordAttribute("userPassword");
    }
}