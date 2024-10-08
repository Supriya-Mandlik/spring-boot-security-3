package com.code.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//InMemory Authentication

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		http.sessionManagement(session
				-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//http.formLogin();
		http.httpBasic();
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user1 = User.withUsername("user1")
				.password("{noop}password1")
				.roles("USER")
				.build();
		
		UserDetails admin = User.withUsername("admin")
				.password("{noop}adminpass")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user1,admin);
	}
	
}
