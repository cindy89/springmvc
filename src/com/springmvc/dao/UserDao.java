package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.User;

public interface UserDao {
	public List<User> findAllUser();
	public void addUser(User user);
	public void deleteUser(User user);
}
