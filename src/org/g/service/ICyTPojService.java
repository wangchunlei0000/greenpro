package org.g.service;

import java.util.List;

import org.g.pojo.CyTPoj;

public interface ICyTPojService {

	public boolean update(CyTPoj c);
	public boolean save(CyTPoj c);
	//public List<CyPoj> findAll(Integer currentPage, Integer pageSize,String userid,String name,Integer id,Integer id2);
	public List<CyTPoj> findAll(String userid);
	public List findBypu(int pojid,String userid);
	public CyTPoj findById(Integer id);
	public int getRowByTitle(String userid,String poname, Integer state, Integer type);
	public List<CyTPoj> findByPojid(Integer pojid);
}
