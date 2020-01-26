package com.app.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Donation;
import com.app.pojos.OrgDonationMapping;
import com.app.pojos.Organisation;
import com.app.pojos.User;
@Repository
public class DonerDaoImp implements IDonerDao 
{
	@Autowired
	SessionFactory sf;
	@Override
	@Transactional
	public int donate(int did, int amt, int orgID) {
		
		String jpql = "select u from Organisation u where u.orgId =:id";
		Organisation o=  sf.getCurrentSession().createQuery(jpql,Organisation.class).setParameter("id", orgID).getSingleResult();

		jpql = "select u from User u where u.userId =:usrID" ;
		User u=  sf.getCurrentSession().createQuery(jpql,User.class).setParameter("usrID", did).getSingleResult();
		
		Donation d = new Donation();
		d.setDonationAmount(amt);
		d.setDonationId(did);
		d.setOrg(o);
		d.setOrgUser(u);
				
		sf.getCurrentSession().save(d);
		

		int newBalance = o.getTotalBalance() + amt;
		
		o.setTotalBalance(newBalance);
		
		sf.getCurrentSession().save(o);
		
		OrgDonationMapping orgDonationMapping = new OrgDonationMapping();
		orgDonationMapping.setDonerId(did);
		orgDonationMapping.setOrgID(orgID);
		
		sf.getCurrentSession().save(orgDonationMapping);
		
		return d.getDonationId();
	}

}
