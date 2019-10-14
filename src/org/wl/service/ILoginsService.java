package org.wl.service;

import java.util.List;

import org.wl.pojo.Logins;


public interface ILoginsService {

	public boolean add(Logins o);
//	public boolean update(Logins lo);
//	public boolean delete(Logins lo);
	public List<Logins> findAll();
	public Logins findById(String id); 
	public int enableBatch(String flag, String ids);
	public int disEnableBatch(String flag, String ids);
	public boolean update(Logins o);
}
