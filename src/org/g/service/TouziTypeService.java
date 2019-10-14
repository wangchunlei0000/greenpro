package org.g.service;

import java.util.List;

import org.g.dao.TouziTypeDAO;
import org.g.pojo.TouziType;

@SuppressWarnings("unchecked")
public class TouziTypeService implements ITouziTypeService {
	private TouziTypeDAO d=new TouziTypeDAO();
	private TouziType o=new TouziType();
	public boolean add(TouziType o) {
		return d.save(o);
	}

	public List<TouziType> findAll() {
		return d.findAll();
	}

	public boolean update(TouziType o) {
		return d.merge(o);
	}

	public TouziType findById(int id) {
		return d.findById(id);
	}
	public boolean delete(TouziType o) {
		return d.delete(o);
	}
	public List findAllke() {
		// TODO Auto-generated method stub
		return d.findAllke();
	}

}
