package org.wl.service;

import java.util.List;

import org.wl.dao.UsersDAO;
import org.wl.pojo.Users;


public class UsersService implements IUsersService{

	private UsersDAO d=new UsersDAO();
	private Users o=new Users();
	
	public boolean add(Users o) {
		
		return d.save(o);
	}

	public boolean update(Users o) {
		return d.merge(o);
	}

	public Users findById(String id) {
		return d.findById(id);
	}
	public List<Users> findAllByTitle(int currentPage,int pageSize,String role,String title){
		return d.findAllByTitle(currentPage,pageSize,role,title);
	}

	public int getRowByTitle(String role, String userid) {
		
		return d.getRowsByTitle(role,userid);
	}
	public List<Users> findAll() {
		return d.findAll();
	}

	
}
