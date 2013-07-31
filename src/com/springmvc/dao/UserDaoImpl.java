package com.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.springmvc.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		return (List<User>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(org.hibernate.Session session)
							throws org.hibernate.HibernateException {
						Query query = session.createQuery("from User");
						List<Object> rows = query.list();
						return rows;
					}
				});
	}

	@Override
	public void addUser(final User user) {
		getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(org.hibernate.Session session)
							throws org.hibernate.HibernateException {
						session.save(user);
						return null;
					}
				});
		
	}

	@Override
	public void deleteUser(final User user) {
		 getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(org.hibernate.Session session)
							throws org.hibernate.HibernateException {
						session.delete(user);
						return null;
					}
				});
	}
	
	
/*	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		Session session=HUtil.getSession();
		List<User> list=new ArrayList<User>();
		try{
			session.beginTransaction();
		    list=session.createQuery("from User").list();
		    session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return list;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session=HUtil.getSession();
		try{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		Session session=HUtil.getSession();
		try{
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}*/
}
