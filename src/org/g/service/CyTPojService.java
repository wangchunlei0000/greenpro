package org.g.service;

import java.util.List;

import org.g.dao.CyTPojDAO;
import org.g.pojo.CyTPoj;

@SuppressWarnings("unchecked")
public class CyTPojService implements ICyTPojService {
	private CyTPojDAO d=new CyTPojDAO();
	private CyTPoj c=new CyTPoj();
	
	public boolean save(CyTPoj c) {
		return d.save(c);
	}
	
	public boolean update(CyTPoj c) {
		// TODO Auto-generated method stub
		return d.merge(c);
	}
	
	public List findBypu(int pojid,String userid){
		return d.findBypu(pojid,userid);
	}

//	public List<CyPoj> findAll(Integer currentPage, Integer pageSize,String userid,String name,Integer id,Integer id2) {
//		// TODO Auto-generated method stub
//		return d.findAll(currentPage,pageSize,userid,name,id,id2);
//	}
	public List<CyTPoj> findAll(String userid){
		return d.findAll(userid);
	}

	public CyTPoj findById(Integer id) {
		// TODO Auto-generated method stub
		return d.findById(id);
	}

	public int getRowByTitle(String userid,String poname, Integer state, Integer type) {
		// TODO Auto-generated method stub
		return d.getRowByTitle( userid,poname, state, type);
	}

	public List<CyTPoj> findByPojid(Integer pojid) {
		// TODO Auto-generated method stub
		return d.findByPojid(pojid);
	}

	

	
	

}
