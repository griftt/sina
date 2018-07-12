package com.dao;

import com.entity.Admin;

public interface AdminDaoInterface {
	public void createAdmin(Admin admin);
	public  Admin checkAdmin(String account,String pwd);
	
	
	
}
