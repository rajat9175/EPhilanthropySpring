package com.app.service;


import java.util.List;

import com.app.pojos.Organisation;
import com.app.pojos.User;

public interface IUserService {
	User registerUser(User u);
	void editProfile(User u,int id);
	User validateUser(User u);
	Organisation getOrganisationbyId(int id);
	User getUserById(int id);
	void deleteUser(int orgId);
	List<Organisation> listFoundations();
}
