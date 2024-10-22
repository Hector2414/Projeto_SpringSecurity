package com.sesi.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfiguracaoSeguranca {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		
		http.authorizeHttpRequests((authorize) -> 
		        authorize
		            .requestMatchers("/login").permitAll()
		            .requestMatchers("/h2-console/**").permitAll()
				    .anyRequest().authenticated()
				)
				.formLogin((form) ->
				    form
				        .loginPage("/login")
				        .defaultSuccessUrl("/home", true)
				        .permitAll()
				        
				   )
				   .logout((logout) -> logout
						   .logoutUrl("logout")
						   .logoutSuccessUrl("/login?logout")
						   .invalidateHttpSession(true)
						   .deleteCookies("JSESSIONID")
						   .permitAll()
						   );
				
		
		
		
		
		return http.build();
		
	}
}
