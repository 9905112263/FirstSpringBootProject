package com.app.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
@Repository
public class UserRepositoryImpl implements UserRepository{

	@Override
	public <S extends UserEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserEntity> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends UserEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
