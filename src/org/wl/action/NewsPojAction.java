package org.wl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.wl.dao.NewsPojDAO;
import org.wl.dao.NewsTypeDAO;
import org.wl.pojo.NewsPoj;
import org.wl.pojo.NewsType;
import org.wl.pojo.Page;
import org.wl.pojo.Users;
import org.wl.service.NewsPojService;
import org.wl.service.NewsTypeService;
import org.wl.service.UsersService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewsPojAction extends ActionSupport{
	NewsTypeDAO dd=new NewsTypeDAO();
	private NewsPoj n=new NewsPoj();
	private Page p=new Page();
	private Users u=new Users();
	UsersService us=new UsersService();
	private NewsPojService s=new NewsPojService();
	NewsType t=new NewsType();
	NewsTypeService ts=new NewsTypeService();
	List<NewsPoj> tlist;
	List<NewsType> ntlistke=dd.findAllke();
	List<NewsType> ntlist=ts.findAll();
	private File mypic;
	private String mypicFileName;
	
	public List<NewsType> getNtlistke() {
		return ntlistke;
	}
	public void setNtlistke(List<NewsType> ntlistke) {
		this.ntlistke = ntlistke;
	}
	public File getMypic() {
		return mypic;
	}
	public void setMypic(File mypic) {
		this.mypic = mypic;
	}
	public String getMypicFileName() {
		return mypicFileName;
	}
	public void setMypicFileName(String mypicFileName) {
		this.mypicFileName = mypicFileName;
	}
	public List<NewsType> getNtlist() {
		return ntlist;
	}
	public void setNtlist(List<NewsType> ntlist) {
		this.ntlist = ntlist;
	}
	public NewsPoj getN() {
		return n;
	}
	public void setN(NewsPoj n) {
		this.n = n;
	}
	public Page getP() {
		return p;
	}
	public void setP(Page p) {
		this.p = p;
	}
	public Users getU() {
		return u;
	}
	public void setU(Users u) {
		this.u = u;
	}
	public NewsType getT() {
		return t;
	}
	public void setT(NewsType t) {
		this.t = t;
	}
	public List<NewsPoj> getTlist() {
		return tlist;
	}
	public void setTlist(List<NewsPoj> tlist) {
		this.tlist = tlist;
	}
	
	public void validateAdd(){
		System.out.println("validatesave11111111111111111");
		if(n.getHead()==null||"".equals(n.getHead())){
			this.addFieldError("p.name", "请填写资讯标题不能为空");
		}if(n.getText()==null||"".equals(n.getText())){
			this.addFieldError("p.name", "请填写资讯内容不能为空");
		}if(t.getId()==null||"".equals(t.getId())){
			this.addFieldError("p.name", "请选择资讯类型");
		}
	}
	
	
	@SuppressWarnings("finally")
	public String add(){
		String r=this.INPUT;
		System.out.println("u.userid_____________-----"+u.getUserid());
		try{
			if(mypic==null){//没有选图片
				n.setState("0");
				Date date=new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Timestamp date0=Timestamp.valueOf(df.format(date));
				n.setStarttime(date0);
				n.setUsers(us.findById(u.getUserid()));
				n.setNewsType(ts.findById(t.getId()));
				s.add(n);
				r= "add";		
			}else{
			String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
			String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
			FileInputStream input=new FileInputStream(mypic);
			FileOutputStream output=new FileOutputStream(savePath);
			System.out.println("userid    savaName"+u.getUserid()+saveName);n.setState("0");
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date0=Timestamp.valueOf(df.format(date));
			n.setStarttime(date0);
			n.setUsers(us.findById(u.getUserid()));
			n.setIcon(saveName);n.setNewsType(ts.findById(t.getId()));
			s.add(n);
			IOUtils.copy(input, output);
			output.flush();
			input.close();
			output.close();
			r="add";
			}
		}catch(Exception e){
			e.printStackTrace();
			r="fail";
		}finally{
			return r;
		}
	}
	public String findAllByTitle(){
		System.out.println("llllllllllllllllllllllllllllllll"+ntlist.toString());
		try{
			String userid=u.getUserid();
			System.out.println("userid ------------  "+userid);
			Integer type=t.getId();
			String head=n.getHead();
			p.setPageSize(10);
			p.setRowCount(s.getRowByTitle(userid,head,type));
			System.out.println("ccccccccccccc"+p.getRowCount());
			tlist=s.findAllByTitle(p.getCurrentPage(),p.getPageSize(),userid,head,type);
			ActionContext.getContext().getSession().put("type",type);//state
			ActionContext.getContext().getSession().put("head",head);
			ActionContext.getContext().getSession().put("tlist",tlist);
			//System.out.println(tlist.toString());
			return "findAllByTitle";
	}catch(Exception e){
		System.out.println("error");
		e.printStackTrace();
		return "fail";}
	}
	public String jubao(){
		System.out.println("llllllllllllllllllllllllllllllll"+ntlist.toString());
		try{
			String userid=u.getUserid();
			System.out.println("userid ------------  "+userid);
			p.setPageSize(10);
			p.setRowCount(s.getjRowByTitle(userid));
			System.out.println("p.getroucount--------------------"+p.getRowCount());
			System.out.println("ccccccccccccc"+p.getRowCount());
			tlist=s.jfindAllByTitle(p.getCurrentPage(),p.getPageSize(),userid);
		
			ActionContext.getContext().getSession().put("ttlist",tlist);
			//System.out.println(tlist.toString());
			return "jubao";
	}catch(Exception e){
		System.out.println("error");
		e.printStackTrace();
		return "fail";}
	}
	public String test1(){
		try{
			System.out.println("test1方法");
			List tttlist=(List<NewsPoj>) ActionContext.getContext().getSession().get("ttlist");
			String userid=u.getUserid();
			p.setPageSize(10);
			p.setRowCount(s.getjRowByTitle(userid));
			System.out.println("ccccccccccccc"+p.getRowCount());
			tttlist=s.jfindAllByTitle(p.getCurrentPage(),p.getPageSize(),userid);				
			tlist=tttlist;
			ActionContext.getContext().getSession().put("ttlist",tlist);
			return "test1";
	}catch(Exception e){
		System.out.println("error");
		return "fail";}
	}
	public String test(){
		try{
			System.out.println("test方法");
			Integer type=(Integer) ActionContext.getContext().getSession().get("type");
			
			String head=(String) ActionContext.getContext().getSession().get("head");
			List ttlist=(List<NewsPoj>) ActionContext.getContext().getSession().get("tlist");
			String userid=u.getUserid();
			
			p.setPageSize(10);
			p.setRowCount(s.getRowByTitle(userid,head,type));
			System.out.println("ccccccccccccc"+p.getRowCount());
			ttlist=s.findAllByTitle(p.getCurrentPage(),p.getPageSize(),userid,head,type);				
			tlist=ttlist;
			ActionContext.getContext().getSession().put("type",type);//state
			ActionContext.getContext().getSession().put("head",head);
			ActionContext.getContext().getSession().put("tlist",tlist);
			return "test";
		
	}catch(Exception e){
		System.out.println("error");
		return "fail";}
	}
	public String tiao(){
		System.out.println("keyong----------------"+ntlistke.toString());
		return "tiao";
	}
	public String delete(){
		try{
			System.out.println(n.getId());
			n=s.findById(n.getId());
			s.delete(n);
			this.addActionMessage("删除成功！");
			return "delete";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}public String look(){
		try{
	
			n=s.findById(n.getId());

			return "look";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	public String llook(){
		try{
			NewsPojDAO nd=new NewsPojDAO();
			
			n=s.findById(n.getId());
			n.setCount(n.getCount()+1);
			if(nd.merge(n)){
				System.out.println(n.getCount());
				return "llook";
			}else{return "fail";}
			
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	public String yfindAll(){
		tlist=s.yfindAllBy(null,null);
		return "yfindAll";
	}
	public String yfindAllBy(){
		try{
			Integer type=t.getId();
			String head=n.getHead();
		tlist=s.yfindAllBy(type,head);
		return "yfindAllBy";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
}
