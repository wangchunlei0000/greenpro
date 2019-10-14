package org.wl.service;

import java.util.List;

import org.wl.dao.RongziPojDAO;
import org.wl.pojo.RongziPoj;

public class RongziPojService implements IRongziPojService{
	
	RongziPojDAO d = new RongziPojDAO();
	public List<RongziPoj> findAll(){
		return d.findAll();
	}
	public List<RongziPoj> findAllByUser(String userid) {
		// TODO Auto-generated method stub
		return d.findAllByUser(userid);
	}
	public boolean save(RongziPoj p) {
		// TODO Auto-generated method stub
		System.out.println("serive");
		return d.save(p);
	}
	public RongziPoj findById(int pojid) {
		
		return d.findById(pojid);
	}
	
	
	public boolean update(RongziPoj p) {
		// TODO Auto-generated method stub
		return d.merge(p);
	}
	public List<RongziPoj> findAllPoj() {
		// TODO Auto-generated method stub
		System.out.println("RongziPojService.findAllPoj");
		return d.findAllPoj();
	}
	public List<RongziPoj> daishen() {
		// TODO Auto-generated method stub
		return d.daishen();
	}
//	public List<RongziPoj> yfindByTitle(String name, Integer state, Integer type) {//, Integer state, Integer type
//		// TODO Auto-generated method stub
//		return d.yfindByTitle(name,state,type);//,state,type
//	}
//	public List<RongziPoj> yfindByTitleq(String name, Integer state, Integer type) {
//		// TODO Auto-generated method stub
//		return d.yfindByTitleq(name,state,type);
//	}
	public List<RongziPoj> jubao() {
		// TODO Auto-generated method stub
		return d.jubao();
	}
	public List<RongziPoj> adminfindall(String name) {
		// TODO Auto-generated method stub
		return d.adminfindall(name);
	}
	public boolean delete(RongziPoj p) {
		return d.delete(p);
	}
	public int getRowByTitle(String userid,String name, Integer id, Integer id2) {
		// TODO Auto-generated method stub
		return d.getRowByTitle(userid,name, id,id2);
	}
	public List<RongziPoj> findAllByTitle(Integer currentPage, Integer  pageSize,
			String userid,String name, Integer id, Integer id2) {
		// TODO Auto-generated method stub
		return d.findAllByTitle(currentPage, pageSize, userid, name ,id, id2);
	}
	public int getyRowByTitle(String name, Integer r11, Integer r22) {
		// TODO Auto-generated method stub
		return d.getyRowByTitle(name, r11,r22);
	}
	public List<RongziPoj> yfindAllByTitle(Integer currentPage, Integer  pageSize,
			String name, Integer id, Integer id2) {
		// TODO Auto-generated method stub
		return d.yfindAllByTitle(currentPage, pageSize, name ,id, id2);
	}
	public int getadRowByTitle(String name, Integer r11, Integer r22) {
		// TODO Auto-generated method stub
		return d.getadRowByTitle(name,r11,r22);
	}
	@SuppressWarnings("unchecked")
//	public List<RongziPoj> adfindByTitle(Integer currentPage, Integer pageSize,
//			String name, Integer r11, Integer r22) {
//		// TODO Auto-generated method stub
//		return d.adfindByTitle( currentPage, pageSize,
//				 name,  r11,  r22);
//	}
	public List<RongziPoj> adfindAllByTitle(Integer currentPage, Integer pageSize,
			String name, Integer r11, Integer r22) {
		// TODO Auto-generated method stub
		return d.adfindAllByTitle( currentPage, pageSize,
				 name,  r11,  r22);
	}
}
