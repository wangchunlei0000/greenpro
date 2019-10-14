package org.wl.action;

import java.util.List;

import org.wl.pojo.RongziType;
import org.wl.service.RongziTypeService;

public class RongziTypeAction {
	
	RongziTypeService s=new RongziTypeService();
	private RongziType o=new RongziType();
	private List<RongziType> lis;

	
	public List<RongziType> getLis() {
		return lis;
	}

	public void setLis(List<RongziType> lis) {
		this.lis = lis;
	}

	public RongziType getO() {
		return o;
	}

	public void setO(RongziType o) {
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
