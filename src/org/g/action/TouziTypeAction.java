package org.g.action;

import java.util.List;

import org.g.pojo.TouziType;
import org.g.service.TouziTypeService;

public class TouziTypeAction {
	
	TouziTypeService s=new TouziTypeService();
	private TouziType o=new TouziType();
	private List<TouziType> lis;

	
	public List<TouziType> getLis() {
		return lis;
	}

	public void setLis(List<TouziType> lis) {
		this.lis = lis;
	}

	public TouziType getO() {
		return o;
	}

	public void setO(TouziType o) {
		this.o = o;
	}

	public String add(){
		if(s.add(o)){
			return "add";
		}
		else{
			return "fail";
		}
	}
	public String findAll(){
		try{
			lis=s.findAll();
			return "findAll";
		}catch(Exception e){
			return "fail";}
	}
	public String update(){
		System.out.println(o.getId()+o.getStyle()+o.getEnable());
		if(s.update(o)){
			return "update";
		}
		return "fail";
	}
	public String toupdate(){
		try{o=s.findById(o.getId());
		return "toupdate";}
		catch(Exception e){
			return "fail";}
	}
	public String todelete(){//获取要删除行的id
		try{o=s.findById(o.getId());
		return "todelete";}catch(Exception e){
			return "fail";}
	}
	public String delete(){
		try{
			s.delete(o);//if/else
			return "delete";
		}catch(Exception e){
			return "fail";}
		}
}
