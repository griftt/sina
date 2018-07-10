package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dao.UserDao;
import com.data.ResultMap;
import com.entity.User;

@Controller
public class UserAction {
	private int page=1;
	private int pagesize=3;
	private List<User> users;
	private int pages;
	ResultMap result;
	
	
	@Resource
	private UserDao dao;
	public String findPage(){
		
		pages=dao.countAll(3);
		System.out.println(pages);
		users=dao.userPage(page, pagesize);
		for(User u:users){
			
		
		System.out.println(u);
		
		}
		result=new ResultMap(0,"",users,users.size());
		return "success";
		
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public ResultMap getResult() {
		return result;
	}

	public void setResult(ResultMap result) {
		this.result = result;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
}
