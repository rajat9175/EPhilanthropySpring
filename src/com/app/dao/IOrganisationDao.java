package com.app.dao;

import java.util.List;

import com.app.pojos.Organisation;
import com.app.pojos.User;

public interface IOrganisationDao 
{
	List<User> listDoner();
	Organisation getOrg(int orgId);
	
	int addOrg(Organisation o);
}
