package com.school.scheduling.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
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
		http.authorizeRequests()
		.antMatchers("/MainView/**").permitAll()
		.antMatchers("/teacherProfile/**").hasRole("TEACHER")
		.antMatchers("/studentProfile/**").hasRole("STUDENT")
		.antMatchers("/room/**").hasAuthority("OIC")
		.antMatchers("/strand/**").hasAuthority("OIC")
		.antMatchers("/subject/**").hasAuthority("OIC")
		.antMatchers("/teacher/**").hasAuthority("OIC")
		.antMatchers("/student/**").hasAuthority("OIC")
		.antMatchers("/breaktime/**").hasAuthority("OIC")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/scheduling/home")
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/"))
		.logoutSuccessUrl("/login")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");

			
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		    .antMatchers("/assets/**","/images/**");
		System.out.println("asdasdasdasdasdasd");
	}
	
	
	
	
	

}
