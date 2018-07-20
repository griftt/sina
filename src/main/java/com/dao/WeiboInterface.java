package com.dao;

import java.util.List;

import com.entity.WeiBo;

public interface WeiboInterface {
	public int countAll();
	public List<WeiBo> findWeiboPage(int page,int pagesize);
	public WeiBo selectById(int id);
	public boolean deleteById(int id);
	List<WeiBo> findWeiboPageById(int page, int pagesize, int id);
	

}
