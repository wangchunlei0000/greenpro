package org.g.service;

import java.util.List;

import org.g.dao.TouziStateDAO;
import org.g.pojo.TouziState;

@SuppressWarnings("unchecked")
public class TouziStateService implements ITouziStateService {
	private TouziStateDAO d=new TouziStateDAO();
	private TouziState o=new TouziState();
	public boolean add(TouziState o) {
		System.out.println("s.add");
		return d.save(o);
	}

	public List<TouziState> findAll() {
		return d.findAll();
	}

	public boolean update(TouziState o) {
		return d.merge(o);
	}

	public TouziState findById(int id) {
		return d.findById(id);
	}
	public boolean delete(TouziState o) {
		return d.delete(o);
	}

}
