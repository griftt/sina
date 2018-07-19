package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDaoInterface {
	public int insertOne(User user);

	public void deleteById(int id);

	public void updateUser(User user);

	public List<User> selectAll();

}
