package org.wl.service;

import java.util.List;

import org.wl.dao.LoginsDAO;
import org.wl.pojo.Logins;


public class LoginsService implements ILoginsService{

	private LoginsDAO d=new LoginsDAO();
	private Logins o=new Logins();
	
	public boolean add(Logins o) {
		return d.save(o);
	}

	public List<Logins> findAll() {
		return d.findAll();
	}

	public Logins findById(String id) {
		return d.findById(id);
	}

	public int enableBatch(String flag, String ids) {
		// TODO Auto-generated method stub
		return d.updateEnableBatch(flag, ids);
	}

	public int disEnableBatch(String flag, String ids) {
		// TODO Auto-generated method stub
		return d.updateEnableBatch(flag, ids);
	}

	public boolean update(Logins o) {
		// TODO Auto-generated method stub
		return d.merge(o);
	}

	
	
}
