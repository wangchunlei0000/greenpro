package org.g.service;

import java.util.List;

import org.g.pojo.TouziPoj;


public interface ITouziPojService {

	public TouziPoj findById(int pojid);
	public List<TouziPoj> findAll();
	public List<TouziPoj> findAllByUser(String userid); 
	public boolean save(TouziPoj p);
	public boolean update(TouziPoj p);
	public List<TouziPoj> findAllPoj();
	public List<TouziPoj> daishen();
	public List<TouziPoj> jubao();
	//public List<RongziPoj> yfindByTitle(String name,Integer state, Integer type);//,Integer state, Integer type
	public List<TouziPoj> adminfindall(String name);
	public boolean delete(TouziPoj p);
	public List<TouziPoj> findAllByTitle(Integer currentPage, Integer  pageSize,
			String userid, String name,Integer id, Integer id2);
	public int getRowByTitle(String userid,String name, Integer id, Integer id2);
	public int getyRowByTitle(String name, Integer r11, Integer r22);
	
	public List<TouziPoj> adfindAllByTitle(Integer currentPage, Integer pageSize,
			String name, Integer r11, Integer r22);
	public int getadRowByTitle(String name, Integer r11, Integer r22);
}
