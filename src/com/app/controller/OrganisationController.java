package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.User;
import com.app.service.IOrganisationService;

@RestController
@CrossOrigin
@RequestMapping("/listDoner")
public class OrganisationController 
{
	@Autowired
	IOrganisationService service;
	
	@GetMapping
	public ResponseEntity<?> listUsers()
	{
		List<User> listOfUsers = service.listDoner();
		if(listOfUsers.size()==0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(listOfUsers,HttpStatus.OK);
	}
	
}
