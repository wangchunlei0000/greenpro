package org.wl.service;

import java.util.List;

import org.wl.pojo.RongziState;

public interface IRongziStateService {
	public boolean add(RongziState o);
	public boolean update(RongziState o);
	public boolean delete(RongziState o);
	public List<RongziState> findAll();
	public RongziState findById(int id); 
}
