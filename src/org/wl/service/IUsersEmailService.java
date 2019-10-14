package org.wl.service;

import java.util.List;

import org.wl.pojo.UsersEmail;


public interface IUsersEmailService {

	public boolean add(UsersEmail o);
	public List<UsersEmail> findByEmail(String userid);
	public UsersEmail findById(Integer id);
	public boolean merge(UsersEmail e);
	public boolean delete(UsersEmail e);
}
