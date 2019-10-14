package org.wl.action;

import java.util.List;

import org.wl.pojo.Users;
import org.wl.pojo.UsersEmail;
import org.wl.service.UsersEmailService;

import com.opensymphony.xwork2.ActionSupport;

public class UsersEmailAction extends ActionSupport {
	
	private Users u=new Users();
	private List<UsersEmail> elist;
	UsersEmailService s=new UsersEmailService();
	private UsersEmail e=new UsersEmail();
	public Users getU() {
		return u;
	}
	public void setU(Users u) {
		this.u = u;
	}

	public UsersEmail getE() {
		return e;
	}
	public void setE(UsersEmail e) {
		this.e = e;
	}
	public List<UsersEmail> getElist() {
		return elist;
	}
	public void setElist(List<UsersEmail> elist) {
		this.elist = elist;
	}
	public String look(){
	 try{
		String userid=u.getUserid();
		System.out.println(userid);
		
		elist=s.findByEmail(userid);
		System.out.println(elist.size());
		int i=0;
		
		while(i<elist.size()){
			System.out.println(elist.get(i).toString());
			i++;
		}
		return "look";
	 }catch(Exception e){
		 return "fail";
	 }
	}
	public String findById(){
		try{
			e=s.findById(e.getId());
			e.setN(1);
			s.merge(e);
			return "findById";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	public String delete(){
		try{
			e=s.findById(e.getId());
			s.delete(e);
			u.setUserid(e.getEmail());
			return "delete";
		}catch(Exception e){
			return "fail";
		}
	}


	
}