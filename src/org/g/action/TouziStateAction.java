package org.g.action;

import java.util.List;

import org.g.pojo.TouziState;
import org.g.service.TouziStateService;

public class TouziStateAction {
	
	TouziStateService s=new TouziStateService();
	private TouziState o=new TouziState();
	private List<TouziState> li;

	public List<TouziState> getLi() {
		return li;
	}

	public void setLi(List<TouziState> li) {
		this.li = li;
	}

	public TouziState getO() {
		return o;
	}

	public void setO(TouziState o) {
		this.o = o;
	}

	public String add(){
		System.out.println(o.getStyle());
		if(s.add(o)){
			System.out.println("add");
			return "add";
		}
		else{
			return "fail";
		}
	}
	public String findAll(){
		try{
			li=s.findAll();
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
