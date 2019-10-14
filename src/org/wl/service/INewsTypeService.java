package org.wl.service;

import java.util.List;

import org.wl.pojo.NewsType;

public interface INewsTypeService {
	public boolean add(NewsType o);
	public boolean update(NewsType o);
	public boolean delete(NewsType o);
	public List<NewsType> findAll();
	public NewsType findById(int id); 
}
