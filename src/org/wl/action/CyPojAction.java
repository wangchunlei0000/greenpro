package org.wl.action;

import java.util.List;

import org.wl.pojo.CyPoj;
import org.wl.pojo.RongziPoj;
import org.wl.pojo.RongziState;
import org.wl.pojo.RongziType;
import org.wl.pojo.Users;
import org.wl.service.CyPojService;
import org.wl.service.RongziPojService;

import com.opensymphony.xwork2.ActionContext;

public class CyPojAction {
	//////////////////////////////
	CyPojService s=new CyPojService();
	private CyPoj c=new CyPoj();
	private List<CyPoj> cyp;
	//RongziPoj poj=new RongziPoj();
	Users u=new Users();
//	Page p=new Page();
	RongziPoj po=new RongziPoj();
	public RongziPoj getPo() {
		return po;
	}
	public void setPo(RongziPoj po) {
		this.po = po;
	}
	RongziState r1=new RongziState();
	RongziType r2=new RongziType();
	public RongziState getR1() {
		return r1;
	}
	public void setR1(RongziState r1) {
		this.r1 = r1;
	}
	public RongziType getR2() {
		return r2;
	}
	public void setR2(RongziType r2) {
		this.r2 = r2;
	}
//	public Page getP() {
//		return p;
//	}
//	public void setP(Page p) {
//		this.p = p;
//	}
	public CyPoj getC() {
		return c;
	}
	public void setC(CyPoj c) {
		this.c = c;
	}
	
public List<CyPoj> getCyp() {
		return cyp;
	}
	public void setCyp(List<CyPoj> cyp) {
		this.cyp = cyp;
	}
		public String findAll(){
		try{
			String userid=u.getUserid();
			cyp=s.findAll(userid);
			return "findAll";
		}catch(Exception e){
			return "fail";}
	}
//	public String findAll(){
//		//String role=(String)ActionContext.getContext().getSession().get("role");//获取登陆的角色
//		Integer state=r1.getId();
//		Integer type=r2.getId();
//		String poname=po.getName();
//		
//		p.setRowCount(s.getRowByTitle(u.getUserid(),poname,state,type));
//		cyp=s.findAll(p.getCurrentPage(),p.getPageSize(),u.getUserid(),poname,state,type);
//		ActionContext.getContext().getSession().put("ponamee",poname);
//		ActionContext.getContext().getSession().put("cypp", cyp);
//		ActionContext.getContext().getSession().put("statee",state);
//		ActionContext.getContext().getSession().put("typee",type);
//		System.out.println(cyp.toString());
//		return "findAll";
//		
//	}
//	@SuppressWarnings("unchecked")
//	public String testt(){
//		String ponamee=(String) ActionContext.getContext().getSession().get("ponamee");
//		Integer statee=(Integer) ActionContext.getContext().getSession().get("statee");
//		Integer typee=(Integer) ActionContext.getContext().getSession().get("typee");
//		List<CyPoj> cypp=(List<CyPoj>) ActionContext.getContext().getSession().get("cypp");
//		p.setRowCount(s.getRowByTitle(u.getUserid(),ponamee,statee,typee));
//		cypp=s.findAll(p.getCurrentPage(),p.getPageSize(),u.getUserid(),ponamee,statee,typee);
//		cyp=cypp;
//		System.out.println(cyp.toString());
//		return "testt";
//	}
	public String look(){
		try{
		c=s.findById(c.getId());
		return "look";}
		catch(Exception e){
			
			return "fail";
		}
	}
	public Users getU() {
		return u;
	}
	public void setU(Users u) {
		this.u = u;
	}
	RongziPoj p=new RongziPoj();
	
	public RongziPoj getP() {
		return p;
	}
	public void setP(RongziPoj p) {
		this.p = p;
	}
	RongziPojService pos=new RongziPojService();
	public String users(){
		try{
		System.out.println("users==============="+po.getPojid());
		ActionContext.getContext().getSession().put("po", po.getPojid());
		p=pos.findById(po.getPojid());
		cyp=s.findByPojid(po.getPojid());
		
//		int co=cyp.size();
//		System.out.println(co);
//		int i=0;
//		System.out.println("cypbe");
//		List users;
//		while(i<co){
//			System.out.println("shuru i");
//			System.out.println(cyp.get(i).getUsers().getUserid());
//			i++;
//			System.out.println("en");
//		}
			return "users";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	
	
}
