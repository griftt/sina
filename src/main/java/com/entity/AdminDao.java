package com.entity;

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
@Repository
public class AdminDao extends HibernateDaoSupport implements AdminDaoInterface {

	@Resource
	public void setSf(SessionFactory sf){
		super.setSessionFactory(sf);
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
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
				
				/*(Admin) tem.executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery("from Admin where account =:account and pwd=:pwd");
				query.setString("account",account);
				query.setString("pwd",pwd);
				Admin list=(Admin) query.uniqueResult();
				if(list!=null){
				return list;
				}else{
					return null;
				}
			}
			
			
		});*/
		
		
	}

}
