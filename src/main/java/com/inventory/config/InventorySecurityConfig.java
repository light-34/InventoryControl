package com.inventory.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.inventory.service.SecurityUserDetailsService;

@Configuration
@EnableWebSecurity
public class InventorySecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new SecurityUserDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/register/**").permitAll()
				.antMatchers("/index").permitAll()
				.antMatchers("/log/**").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
				.formLogin(
						form -> form.loginPage("/log/login")
											.defaultSuccessUrl("/log/hello")
											.permitAll())
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/log/access-denied");
		
		return http.build();
			
	}
}
