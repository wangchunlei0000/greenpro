package org.wl.service;

import java.util.List;

import org.wl.pojo.RongziPoj;


public interface IRongziPojService {

	public RongziPoj findById(int pojid);
	public List<RongziPoj> findAll();
	public List<RongziPoj> findAllByUser(String userid); 
	public boolean save(RongziPoj p);
	public boolean update(RongziPoj p);
	public List<RongziPoj> findAllPoj();
	public List<RongziPoj> daishen();
	public List<RongziPoj> jubao();
	//public List<RongziPoj> yfindByTitle(String name,Integer state, Integer type);//,Integer state, Integer type
	public List<RongziPoj> adminfindall(String name);
	public boolean delete(RongziPoj p);
	public List<RongziPoj> findAllByTitle(Integer currentPage, Integer  pageSize,
			String userid, String name,Integer id, Integer id2);
	public int getRowByTitle(String userid,String name, Integer id, Integer id2);
	public int getyRowByTitle(String name, Integer r11, Integer r22);
	
	public List<RongziPoj> adfindAllByTitle(Integer currentPage, Integer pageSize,
			String name, Integer r11, Integer r22);
	public int getadRowByTitle(String name, Integer r11, Integer r22);
}
