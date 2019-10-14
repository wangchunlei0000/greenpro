package org.wl.service;

import java.util.List;

import org.wl.dao.NewsTypeDAO;
import org.wl.pojo.NewsType;

@SuppressWarnings("unchecked")
public class NewsTypeService implements INewsTypeService {
	private NewsTypeDAO d=new NewsTypeDAO();
	private NewsType o=new NewsType();
	public boolean add(NewsType o) {
		return d.save(o);
	}

	public List<NewsType> findAll() {
		return d.findAll();
	}

	public boolean update(NewsType o) {
		return d.merge(o);
	}

	public NewsType findById(int id) {
		return d.findById(id);
	}
	public boolean delete(NewsType o) {
		return d.delete(o);
	}

}
