package org.wl.service;

import java.util.List;

import org.wl.dao.NewsPojDAO;
import org.wl.pojo.NewsPoj;

public class NewsPojService implements INewsPojService {
	
	private NewsPojDAO d =new NewsPojDAO();
	public int getRowByTitle(String userid, String head, Integer type) {
		// TODO Auto-generated method stub
		return d.getRowByTitle(userid,head,type);
	}

	public List<NewsPoj> findAllByTitle(int currentPage, int pageSize,
			String userid, String head, Integer type) {
		// TODO Auto-generated method stub
		return d.findAllByTitle(currentPage, pageSize, userid, head,type);
	}

	public boolean add(NewsPoj n) {
		// TODO Auto-generated method stub
		return d.save(n);
	}

	public NewsPoj findById(Integer id) {
		// TODO Auto-generated method stub
		return d.findById(id);
	}

	public boolean delete(NewsPoj n) {
		// TODO Auto-generated method stub
		return d.delete(n);
	}

	public int getjRowByTitle(String userid) {
		// TODO Auto-generated method stub
		return d.getjRowByTitle(userid);
	}

	public List<NewsPoj> jfindAllByTitle(int currentPage, int pageSize,
			String userid) {
		// TODO Auto-generated method stub
		return d.jfindAllByTitle(currentPage,pageSize,userid);
	}

	public List<NewsPoj> yfindAllBy(Integer type, String head) {
		// TODO Auto-generated method stub
		return d.yfindAllBy(type,head);
	}
	
	

}
