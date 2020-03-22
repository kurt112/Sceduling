package com.school.scheduling.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDataSource)
		.passwordEncoder(new BCryptPasswordEncoder());
	//	.usersByUsernameQuery("")
		//.authoritiesByUsernameQuery("");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
//		http.authorizeRequests()
//		.antMatchers("/MainView/**").permitAll()
//		.antMatchers("/room/**").hasRole("MANAGER")
//		.antMatchers("/strand/**").hasRole("ADMIN")
//		.antMatchers("/subject/**").hasRole("ADMIN")
//		.antMatchers("/teacher/**").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.defaultSuccessUrl("MainView/main-view")
//		.loginPage("/login")
		//.loginProcessingUrl("MainView/main-view")
//		.permitAll()
//		.and()
//		.logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/"))
//		.logoutSuccessUrl("/login")
//		.permitAll();
//		.and()
//		.exceptionHandling().accessDeniedPage("/access-denied");

			
	}
	
	
	
	

}
