package com.app.impl.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import com.app.shared.utils.Utils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	Utils utils;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub

		// UserEntity storedUserDetails
		// =userRepository.findUserByEmail(user.getEmail());
		if (userRepository.findUserByEmail(user.getEmail()) != null)
			throw new RuntimeException("Record already exists");

		UserEntity userEntity = new UserEntity();

		BeanUtils.copyProperties(user, userEntity);

		userEntity.setEncryptedPassword("test");

		String publicUserId = utils.generateRandomString(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, userDto);
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findUserByEmail(email);
		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUser(String email) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findUserByEmail(email);
		if (userEntity == null)
			throw new UsernameNotFoundException(email);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);

		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		// TODO Auto-generated method stub

		UserDto returnValue = new UserDto();

		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException(userId);

		BeanUtils.copyProperties(userEntity, returnValue);

		return returnValue;
	}

}
