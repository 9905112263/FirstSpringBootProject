package com.app.ws.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.service.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	  private final UserService userService;
	  private final BCryptPasswordEncoder bCryptPasswordEncoder;
	  
	  public WebSecurity(UserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
		  this.bCryptPasswordEncoder=bCryptPasswordEncoder;
		  this.userService=userService;
		  
	  }
	
	   protected void cofigure(HttpSecurity http) throws Exception{
	         http.csrf().disable().authorizeRequests()
	         .antMatchers(HttpMethod.POST,"/users")
	         .permitAll()
	         .anyRequest()
	         .authenticated();
//	         .authorizeRequests()
//	         .antMatchers("/").permitAll()
//	         .antMatchers("/app/").permitAll()
//	         .and().formLogin();
	    }
	   
	   public void configure(AuthenticationManagerBuilder auth) throws Exception{
	        auth.inMemoryAuthentication().withUser("user").password("password").roles("ROLE_USER");
	    }

}
