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

import com.dao.AdminDaoInterface;
import com.entity.Admin;
@Repository
public class AdminDao extends HibernateDaoSupport implements AdminDaoInterface {

	@Resource
	public void setSf(SessionFactory sf){
		super.setSessionFactory(sf);
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Admin checkAdmin(final String account, final String pwd) {
		// TODO Auto-generated method stub
		HibernateTemplate tem=super.getHibernateTemplate();
		
		List<Admin> admin= (List<Admin>) tem.find("from Admin where account ="+account+ "and pwd="+pwd); 
				if(admin.size()!=0){
					return admin.get(0); 
				}else{
					return null;
				}
				
			
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Admin> adminPage(final int page,final int pagesize){
		 HibernateTemplate tem = super.getHibernateTemplate();
		List<Admin> admins=(List<Admin>) tem.executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query =session.createQuery("from Admin");
				query.setFirstResult((page-1)*pagesize);
				query.setMaxResults(pagesize);
				
				return  query.list();
			}
			
		});
		
		
		return admins;
		
	}
	public int countAll(int pagesize){
		HibernateTemplate tem = super.getHibernateTemplate();
		
		List<Object> list=(List<Object>) tem.find("select count(*) from Admin");
		int num= Integer.parseInt(list.get(0).toString());
		if(num%pagesize==0){
			return num/pagesize;
			
		}else{
			return num/pagesize+1;
		}
		
		
	}

	@Override
	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		HibernateTemplate tem=super.getHibernateTemplate();
		tem.save(admin);
	}
	

}
