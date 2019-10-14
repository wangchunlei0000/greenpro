package org.wl.service;

import java.util.List;

import org.wl.pojo.CyPoj;

public interface ICyPojService {

	public boolean update(CyPoj c);
	public boolean save(CyPoj c);
	//public List<CyPoj> findAll(Integer currentPage, Integer pageSize,String userid,String name,Integer id,Integer id2);
	public List<CyPoj> findAll(String userid);
	public List findBypu(int pojid,String userid);
	public CyPoj findById(Integer id);
	public int getRowByTitle(String userid,String poname, Integer state, Integer type);
	public List<CyPoj> findByPojid(Integer pojid);
}
