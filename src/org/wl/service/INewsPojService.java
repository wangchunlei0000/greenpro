package org.wl.service;

import java.util.List;

import org.wl.pojo.NewsPoj;

public interface INewsPojService {
	public int getRowByTitle(String userid, String head, Integer type);
	public List<NewsPoj> findAllByTitle(int currentPage, int pageSize,
			String userid, String head, Integer type);
	public boolean add(NewsPoj n);
	public NewsPoj findById(Integer id);
	public boolean delete(NewsPoj n);
	public int getjRowByTitle(String userid);
	public List<NewsPoj> jfindAllByTitle(int currentPage, int pageSize,
			String userid);
	public List<NewsPoj> yfindAllBy(Integer type, String head2);
	
}
