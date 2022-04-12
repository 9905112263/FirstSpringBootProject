package com.app.ws.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.dto.UserDto;
import com.app.model.UserLoginRequestModel;
import com.app.service.UserService;
import com.example.FirstSpringBootProject.SpringApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
 
	 private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		try {
			
			UserLoginRequestModel  creds=new ObjectMapper().readValue(request.getInputStream(), UserLoginRequestModel.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(),creds.getPassword(),new ArrayList<>()));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return super.attemptAuthentication(request, response);
	}
	
	
	protected void SuccessfulAuthentication(HttpServletRequest request,HttpServletResponse response,FilterChain chain, Authentication auth) throws IOException, ServletException{
		
		String userName=((User)auth.getPrincipal()).getUsername();
		String token =Jwts.builder()
				     .setSubject(userName)
				     .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				     .signWith(SignatureAlgorithm.ES512, SecurityConstants.TOKEN_SECRET)
				     .compact();
		
		UserService userService=(UserService)SpringApplicationContext.getBean("userServiceImpl");
		UserDto userDto=userService.getUser(userName);
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+token);
		response.addHeader("UserId", userDto.getUserId());
	}
	
	
	
	
	
}
