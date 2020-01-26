package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrganisationDao;
import com.app.pojos.Organisation;
import com.app.pojos.User;

@Service
@Transactional

public class OrganisationServiceImpl implements IOrganisationService {
	
@Autowired
IOrganisationDao dao;


	@Override
	public List<User> listDoner() {
		
		return dao.listDoner();
	}
	
	
	@Override
	public int addOrg(Organisation o) {
		
		return dao.addOrg(o);
		
		
	}
}
