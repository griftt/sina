package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dao.UserDao;
import com.data.ResultMap;
import com.entity.User;

@Controller
@Scope("prototype")
public class UserAction {
	private int page = 1;
	private int limit;
	private List<User> users;
	private int pages;
	private String account;

	ResultMap result;

	@Resource
	private UserDao dao;

	public String findPage() {
		System.out.println(page + "--" + limit);
		pages = dao.countAll();
		System.out.println(pages);
		users = dao.userPage(page, limit);
		System.out.println("--------------------------------------------");
		for (User u : users) {
			System.out.println(u);
		}
		result = new ResultMap(0, "", users, pages);
		return "success";

	}

	public String searchUser() {
		System.out.println(account);

		users = dao.selectLike(account);
		System.out.println(users);
		result = new ResultMap(0, "", users, users.size());
		return "success";

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

}
