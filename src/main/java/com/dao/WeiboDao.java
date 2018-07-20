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

import com.entity.WeiBo;

@Repository
public class WeiboDao extends HibernateDaoSupport implements WeiboInterface {

	@Resource
	public void setSf(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		HibernateTemplate tem = super.getHibernateTemplate();

		List<Object> list = (List<Object>) tem.find("select count(*) from WeiBo");

		int num = Integer.parseInt(list.get(0).toString());
		return num;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<WeiBo> findWeiboPageById(final int page, final int pagesize, final int id ) {
		// TODO Auto-generated method stub
		HibernateTemplate tem = super.getHibernateTemplate();
		
		return (List<WeiBo>) tem.executeFind(new HibernateCallback() {

			@Override
			public List<WeiBo> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery("from WeiBo where userId="+id);
				query.setFirstResult((page-1)*pagesize);
				query.setMaxResults(pagesize);
				return query.list();
			}
			
		});
	}

	@Override
	public WeiBo selectById(int id) {
		// TODO Auto-generated method stub
		HibernateTemplate tem = super.getHibernateTemplate();
		if(id<=0){
			return null;
		}else{
			WeiBo wb=tem.get(WeiBo.class, id);
			if(wb!=null){
				
				return wb;
			}
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		HibernateTemplate tem = super.getHibernateTemplate();
		WeiBo wb=null;
		if(id<=0){
			return false;
		}else{
			wb=tem.get(WeiBo.class, id);
			if(wb!=null){
				tem.delete(wb);
				return true;
			}
		}
		
		return false;
		
	
	}

	@Override
	public List<WeiBo> findWeiboPage(int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
