package org.wl.service;

import java.util.List;

import org.wl.dao.RongziStateDAO;
import org.wl.pojo.RongziState;

@SuppressWarnings("unchecked")
public class RongziStateService implements IRongziStateService {
	private RongziStateDAO d=new RongziStateDAO();
	private RongziState o=new RongziState();
	public boolean add(RongziState o) {
		System.out.println("s.add");
		return d.save(o);
	}

	public List<RongziState> findAll() {
		return d.findAll();
	}

	public boolean update(RongziState o) {
		return d.merge(o);
	}

	public RongziState findById(int id) {
		return d.findById(id);
	}
	public boolean delete(RongziState o) {
		return d.delete(o);
	}

}
