package org.g.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.g.dao.CyTPojDAO;
import org.g.pojo.CyTPoj;
import org.g.pojo.TouziPoj;
import org.g.pojo.TouziState;
import org.g.pojo.TouziType;
import org.g.service.CyTPojService;
import org.g.service.TouziPojService;
import org.wl.pojo.Users;
import org.wl.service.UsersService;

import com.opensymphony.xwork2.ActionContext;

public class CyTPojAction {
	
	CyTPojService s=new CyTPojService();
	private CyTPoj c=new CyTPoj();
	private List<CyTPoj> cyp;
	//RongziPoj poj=new RongziPoj();
	Users u=new Users();
//	Page p=new Page();
	TouziPoj po=new TouziPoj();
	public TouziPoj getPo() {
		return po;
	}
	public void setPo(TouziPoj po) {
		this.po = po;
	}
	TouziState r1=new TouziState();
	TouziType r2=new TouziType();
	public TouziState getR1() {
		return r1;
	}
	public void setR1(TouziState r1) {
		this.r1 = r1;
	}
	public TouziType getR2() {
		return r2;
	}
	public void setR2(TouziType r2) {
		this.r2 = r2;
	}
//	public Page getP() {
//		return p;
//	}
//	public void setP(Page p) {
//		this.p = p;
//	}
	public CyTPoj getC() {
		return c;
	}
	public void setC(CyTPoj c) {
		this.c = c;
	}
	
public List<CyTPoj> getCyp() {
		return cyp;
	}
	public void setCyp(List<CyTPoj> cyp) {
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
//		//String role=(String)ActionContext.getContext().getSession().get("role");//获取登陆的角�?
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
	TouziPoj p=new TouziPoj();
	
	public TouziPoj getP() {
		return p;
	}
	public void setP(TouziPoj p) {
		this.p = p;
	}
	TouziPojService pos=new TouziPojService();
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
	public void state(){
		
		Date date=new Date();//当前日期
		CyTPojDAO dd=new CyTPojDAO();
		List<CyTPoj> cc=dd.statefindAll();
		int tt=cc.size();
		
		try {
			int i=0;
		while(i<tt){
				Date dda=((CyTPoj) cc.get(i)).getBy1();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				Date start;
				Date date0;
				
				
				start = sdf.parse(sdf.format(dda));//开始投资的日期
				System.out.println("开始投资："+start);
				date0 = sdf.parse(sdf.format(date));//当前日期
				System.out.println("当前日期："+date0);
				


				Calendar calendar=Calendar.getInstance();
				int year0=calendar.get(Calendar.YEAR);
				calendar.setTime(start);
				int start0=calendar.get(Calendar.YEAR);
				System.out.println(date0+"-----"+date0.toString());
				int be=year0-start0;
				
				System.out.println("发布几天"+be);
				if(be-cc.get(i).getCount()>0){
					double tuim=cc.get(i).getMoney()*0.05*be;
					System.out.println(tuim);
					Users uu=new Users();
					UsersService us=new UsersService();
					uu=us.findById(cc.get(i).getUsers().getUserid());
					System.out.println("userid-----"+uu.getUserid());
					
					java.text.DecimalFormat df=new java.text.DecimalFormat("#0.00");   
					 
					java.math.BigDecimal big = new java.math.BigDecimal(df.format(tuim));
					big = new java.math.BigDecimal(df.format(tuim));
					
					System.out.println("user.money------"+uu.getMoney());
					uu.setMoney(uu.getMoney()+tuim);
					System.out.println("nehind ------"+uu.getMoney());
					us.update(uu);
					cc.get(i).setCount(be);
					s.update(cc.get(i));
				}i++;
		}
				 
		}catch(Exception e){
			e.printStackTrace();}
		}
		
	
	
}
