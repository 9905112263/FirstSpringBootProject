package com.app.impl.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import com.app.shared.utils.Utils;
@Service
public class UserServiceImpl implements UserService{
      @Autowired
	  UserRepository userRepository;
      @Autowired
      Utils utils;
	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		
		//UserEntity storedUserDetails =userRepository.findUserByEmail(user.getEmail());
		if(userRepository.findUserByEmail(user.getEmail()) !=null) throw new RuntimeException("Record already exists");
		
		UserEntity userEntity=new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("test");
		
		String publicUserId=utils.generateRandomString(30);
		userEntity.setUserId(publicUserId);
		
		UserEntity storedUserDetails=userRepository.save(userEntity);
		
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(storedUserDetails, userDto);
		return null;
	}

}
