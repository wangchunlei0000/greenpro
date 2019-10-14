package org.wl.service;

import java.util.List;

import org.wl.dao.RongziTypeDAO;
import org.wl.pojo.RongziType;

@SuppressWarnings("unchecked")
public class RongziTypeService implements IRongziTypeService {
	private RongziTypeDAO d=new RongziTypeDAO();
	private RongziType o=new RongziType();
	public boolean add(RongziType o) {
		return d.save(o);
	}

	public List<RongziType> findAll() {
		return d.findAll();
	}

	public boolean update(RongziType o) {
		return d.merge(o);
	}

	public RongziType findById(int id) {
		return d.findById(id);
	}
	public boolean delete(RongziType o) {
		return d.delete(o);
	}

	public List findAllke() {
		// TODO Auto-generated method stub
		return d.findAllke();
	}

}
