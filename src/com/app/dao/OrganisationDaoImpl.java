package com.app.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Organisation;
import com.app.pojos.Role;
import com.app.pojos.User;
@Repository
public class OrganisationDaoImpl implements IOrganisationDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public List<User> listDoner() {
		String jpql = "select u from User u where u.role=:rl";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("rl", Role.DONER).getResultList();
	}
	
	@Override
	public Organisation getOrg(int orgID) {
		String jpql = "select u from organisation u where u.orgId =:id";
		return sf.getCurrentSession().createQuery(jpql,Organisation.class).setParameter("id", orgID).getSingleResult();

	}

	@Override
	public int addOrg(Organisation o) {
		sf.getCurrentSession().save(o);
		return o.getOrgId();
	}
	
	
}
