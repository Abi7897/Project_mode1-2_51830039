package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
@EnableWebSecurity
public class WebAppSecConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BasicAuthenticationEntryPoint authenticationEntryPoint;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public BCryptPasswordEncoder getEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
		.antMatchers("/clerk/**").hasAnyRole("ADMIN","MGR","CLERK")
		.antMatchers("/home/**").authenticated()
		.and().formLogin()
		.loginPage("/login").loginProcessingUrl("/loginaction")
		.usernameParameter("email").passwordParameter("password")
		.defaultSuccessUrl("/home")
		.permitAll()
		.and()
		.httpBasic()
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		.and().sessionManagement().maximumSessions(1);
	}
	

}


