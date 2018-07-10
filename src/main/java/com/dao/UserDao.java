package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository
public class UserDao extends HibernateDaoSupport implements UserDaoInterface {

	

	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	@Override
	public int insertOne(User user) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		 HibernateTemplate tem = super.getHibernateTemplate();
		 List<User> users= (List<User>) tem.find("from User");
			
		return users;
	}
	public User findById(int id){
		 HibernateTemplate tem = super.getHibernateTemplate();
		 return tem.get(User.class, id);
	}
	@SuppressWarnings("deprecation")
	public List<User> userPage(final int page,final int pagesize){
		 HibernateTemplate tem = super.getHibernateTemplate();
		List<User> users=(List<User>) tem.executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query =session.createQuery("from User");
				query.setFirstResult((page-1)*pagesize);
				query.setMaxResults(pagesize);
				
				return  query.list();
			}
			
		});
		
		
		return users;
		
	}
	public int countAll(int pagesize){
		HibernateTemplate tem = super.getHibernateTemplate();
		
		List<Object> list=(List<Object>) tem.find("select count(*) from User ");
		int num= Integer.parseInt(list.get(0).toString());
		if(num%pagesize==0){
			return num/pagesize;
			
		}else{
			return num/pagesize+1;
		}
		
		
	}

	
	
}
