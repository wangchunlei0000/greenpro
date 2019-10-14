package org.wl.service;

import java.util.List;

import org.wl.dao.CyPojDAO;
import org.wl.pojo.CyPoj;

@SuppressWarnings("unchecked")
public class CyPojService implements ICyPojService {
	private CyPojDAO d=new CyPojDAO();
	private CyPoj c=new CyPoj();
	
	public boolean save(CyPoj c) {
		return d.save(c);
	}
	
	public boolean update(CyPoj c) {
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
	public List<CyPoj> findAll(String userid){
		return d.findAll(userid);
	}

	public CyPoj findById(Integer id) {
		// TODO Auto-generated method stub
		return d.findById(id);
	}

	public int getRowByTitle(String userid,String poname, Integer state, Integer type) {
		// TODO Auto-generated method stub
		return d.getRowByTitle( userid,poname, state, type);
	}

	public List<CyPoj> findByPojid(Integer pojid) {
		// TODO Auto-generated method stub
		return d.findByPojid(pojid);
	}

	

	
	

}
