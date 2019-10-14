package org.wl.service;

import java.util.List;

import org.wl.dao.UsersEmailDAO;
import org.wl.pojo.UsersEmail;


public class UsersEmailService implements IUsersEmailService{

	private UsersEmailDAO d=new UsersEmailDAO();
	private UsersEmail o=new UsersEmail();
	
	public boolean add(UsersEmail o) {
		
		return d.save(o);
	}

	public List<UsersEmail> findByEmail(String userid) {
		// TODO Auto-generated method stub
		return d.findByEmail(userid);
	}

	public UsersEmail findById(Integer id) {
		// TODO Auto-generated method stub
		return d.findById(id);
	}

	public boolean merge(UsersEmail e) {
		// TODO Auto-generated method stub
		return d.merge(e);
	}

	public boolean delete(UsersEmail e) {
		// TODO Auto-generated method stub
		return d.delete(e);
	}


	
}
