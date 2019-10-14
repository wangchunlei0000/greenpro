package org.wl.action;

import java.util.List;

import org.wl.pojo.NewsType;
import org.wl.service.NewsTypeService;

public class NewsTypeAction {
	
	NewsTypeService s=new NewsTypeService();
	private NewsType o=new NewsType();
	private List<NewsType> list;

	public List<NewsType> getList() {
		return list;
	}

	public void setList(List<NewsType> list) {
		this.list = list;
	}

	public NewsType getO() {
		return o;
	}

	public void setO(NewsType o) {
		this.o = o;
	}

	public String add(){
		System.out.println(o.getStyle());
		if(s.add(o)){
			return "add";
		}
		else{
			return "fail";
		}
	}
	public String findAll(){
		try{
			list=s.findAll();
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
