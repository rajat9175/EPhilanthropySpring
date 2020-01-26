package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDonerDao;

@Service
public class DonateService implements IDonateService 
{
	@Autowired
	IDonerDao dao;
	@Override
	public int donate(int did, int amt,int orgId) {
		 return  dao.donate(did, amt, orgId);
		
	}
	
}
