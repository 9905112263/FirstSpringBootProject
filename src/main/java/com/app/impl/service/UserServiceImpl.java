package com.app.impl.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import com.app.service.UserService;
@Service
public class UserServiceImpl implements UserService{
      @Autowired
	  UserRepository userRepository;
	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		UserEntity userEntity=new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("testUserId");
		
		UserEntity storedUserDetails=userRepository.save(userEntity);
		
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(storedUserDetails, userDto);
		return null;
	}

}
