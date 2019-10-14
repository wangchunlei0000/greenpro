package org.wl.service;

import java.util.List;

import org.wl.pojo.RongziType;

public interface IRongziTypeService {
	public boolean add(RongziType o);
	public boolean update(RongziType o);
	public boolean delete(RongziType o);
	public List<RongziType> findAll();
	public RongziType findById(int id); 
	public List findAllke();
}
