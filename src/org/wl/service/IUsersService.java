package org.wl.service;

import java.util.List;

import org.wl.pojo.Users;


public interface IUsersService {

	public boolean add(Users o);
	public boolean update(Users o);
//	public boolean delete(Logins lo);
	public List<Users> findAll();
	public Users findById(String id); 
	public List<Users> findAllByTitle(int currentPage,int pageSize,String role,String title);
}
