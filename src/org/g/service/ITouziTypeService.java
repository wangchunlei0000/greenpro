package org.g.service;

import java.util.List;

import org.g.pojo.TouziType;

public interface ITouziTypeService {
	public boolean add(TouziType o);
	public boolean update(TouziType o);
	public boolean delete(TouziType o);
	public List<TouziType> findAll();
	public TouziType findById(int id); 
	public List findAllke();
}
