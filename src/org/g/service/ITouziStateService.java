package org.g.service;

import java.util.List;

import org.g.pojo.TouziState;

public interface ITouziStateService {
	public boolean add(TouziState o);
	public boolean update(TouziState o);
	public boolean delete(TouziState o);
	public List<TouziState> findAll();
	public TouziState findById(int id); 
}
