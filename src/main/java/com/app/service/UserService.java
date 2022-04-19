package com.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.dto.UserDto;

public interface UserService extends UserDetailsService{
 UserDto createUser(UserDto user);
 UserDto getUser(String email);
 UserDto getUserByUserId(String userId);
}
