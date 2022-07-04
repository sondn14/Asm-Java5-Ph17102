package com.asm.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.asm.model.User;
import com.asm.reponsitory.IUserReponsitory;
import com.asm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private IUserReponsitory userReponsitory;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public <S extends User> S save(S entity) {
		entity.setPassWord(entity.getPassWord());
		return userReponsitory.save(entity);
	}

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		return userReponsitory.findOne(example);
	}

	@Override
	public List<User> findAll() {
		return userReponsitory.findAll();
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userReponsitory.findAll(pageable);
	}

	@Override
	public List<User> findAll(Sort sort) {
		return userReponsitory.findAll(sort);
	}

	@Override
	public List<User> findAllById(Iterable<String> ids) {
		return userReponsitory.findAllById(ids);
	}

	@Override
	public Optional<User> findById(String id) {
		return userReponsitory.findById(id);
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		return userReponsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		userReponsitory.flush();
	}

	@Override
	public boolean existsById(String id) {
		return userReponsitory.existsById(id);
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		return userReponsitory.saveAndFlush(entity);
	}

	@Override
	public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
		return userReponsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return userReponsitory.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
		userReponsitory.deleteInBatch(entities);
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		return userReponsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<User> entities) {
		userReponsitory.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return userReponsitory.count();
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		return userReponsitory.exists(example);
	}

	@Override
	public void deleteById(String id) {
		userReponsitory.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		userReponsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(User entity) {
		userReponsitory.delete(entity);
	}

	@Override
	public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return userReponsitory.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		userReponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		userReponsitory.deleteAllInBatch();
	}

	@Override
	public User getOne(String id) {
		return userReponsitory.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		userReponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userReponsitory.deleteAll();
	}

	@Override
	public User getById(String id) {
		return userReponsitory.getById(id);
	}

	@Override
	public User getReferenceById(String id) {
		return userReponsitory.getReferenceById(id);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		return userReponsitory.findAll(example);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return userReponsitory.findAll(example, sort);
	}

	@Override
	public User login(String userName, String passWord) {
		Optional<User> optExist = findById(userName);
		if(optExist.isPresent() && passWord.equals(optExist.get().getPassWord())) {
			System.out.print("chạy đc vào đây");;
			optExist.get().setPassWord("");
			return optExist.get();
		}
		return null;
	}
	
	@Override
	public User forgot(String userName, String email) {
		Optional<User> optExist = findById(userName);
		if(optExist.isPresent() && email.equals(optExist.get().getEmail())) {
			System.out.print("chạy đc vào đây");;
			optExist.get().setEmail("");
			return optExist.get();
		}
		return null;
	}
	
	@Override
	public User updateByUserName(String userName, int kq) {
		Optional<User> user = findById(userName);
		String ketQua = String.valueOf(kq);
		user.get().setPassWord(ketQua);
		return user.get();
	}
	
}
