package com.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Organisation;
import com.app.pojos.User;

@Service
@Transactional


public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDao dao;

	@Override
	public User registerUser(User u) {
		return dao.register(u);
	}

	@Override
	public void editProfile(User u, int id) {
		u.setUserId(id);  
		if( u!= null)
			dao.editProfile(u);
		
	}

	@Override
	public User validateUser(User u) {
		System.out.println("validate services");
		User u2 = dao.validateUser(u);
		System.out.println("In UserServiceImpl validateUser() "+u2.toString());
		return u2;		
	}
	
	
	
	@Override
	public List<Organisation> listFoundations() 
	{
		return dao.listFoundations();
	}
	@Override
	public Organisation getOrganisationbyId(int id) {
		return dao.getOrganisationbyId(id);
	}



	@Override
	public void deleteUser(int orgId) {
		Organisation uById = dao.getOrganisationbyId(orgId);
		if(uById != null)
			dao.deleteOrganisation(uById);
		
	}

	@Override
	public User getUserById(int id) {
		return dao.getUserbyId(id);
	}
	
	

}	
