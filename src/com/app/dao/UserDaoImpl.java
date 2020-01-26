package com.app.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Organisation;
import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public User register(User u) {
		
		sf.getCurrentSession().save(u);
		return u;
	}

	@Override
	public void editProfile(User u) {
		System.out.println("Inside editProfile UserDaoImpl : "+u.toString());	
		sf.getCurrentSession().update(u);
		
	}

	@Override
		
		public User validateUser(User u) {
		System.out.println("inside validATED DAO");
		System.out.println(u.getEmail()+" "+u.getPassword());
			String jpql = "select u from User u where u.email=:em and u.password=:pass";
			return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em",u.getEmail()).setParameter("pass", u.getPassword()).getSingleResult();
	}


	@Override
	public List<Organisation> listFoundations() {
		String jpql = "select o from Organisation o";
		List<Organisation> list = sf.getCurrentSession().createQuery(jpql,Organisation.class).getResultList();
		return list;
	}
	@Override
	public Organisation getOrganisationbyId(int id) {
		return sf.getCurrentSession().get(Organisation.class,id);
	}
	
	@Override
	public void deleteOrganisation(Organisation o) {
		sf.getCurrentSession().delete(o);
		
		
	}

	@Override
	public User getUserbyId(int id) {
		return sf.getCurrentSession().get(User.class,id);
	}
	


}
