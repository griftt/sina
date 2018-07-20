package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dao.WeiboDao;
import com.data.ResultMap;
import com.entity.WeiBo;

@Controller
@Scope("prototype")
public class WeiboAction {
	private int id;
	private int page=1;
	private int limit;
	private int all;
	private ResultMap result;
	@Resource
	public WeiboDao weiboDao;
	
	public String findWeiboPage(){
		System.out.println(id+"dddddddddddddddddddddd");
		if(page<0||limit<0){
			return "error";
		}
		all=weiboDao.countAll();
		if(all==0){
			all+=1;
		}
		List<WeiBo> list=weiboDao.findWeiboPageById(page, limit,id);
		result=new ResultMap(0,"",list,all);
		System.out.println(list.size());
		return "success";
		
		
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

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public ResultMap getResult() {
		return result;
	}

	public void setResult(ResultMap result) {
		this.result = result;
	}

	public WeiboDao getWeiboDao() {
		return weiboDao;
	}

	public void setWeiboDao(WeiboDao weiboDao) {
		this.weiboDao = weiboDao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
