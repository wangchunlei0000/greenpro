package org.g.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.g.dao.TouziPojDAO;
import org.g.dao.TouziStateDAO;
import org.g.dao.TouziTypeDAO;
import org.g.pojo.CyTPoj;
import org.g.pojo.TouziPoj;
import org.g.pojo.TouziState;
import org.g.pojo.TouziType;
import org.g.service.CyTPojService;
import org.g.service.TouziPojService;
import org.g.service.TouziStateService;
import org.g.service.TouziTypeService;
import org.wl.dao.UsersDAO;
import org.wl.pojo.Page;
import org.wl.pojo.Users;
import org.wl.pojo.UsersEmail;
import org.wl.service.UsersEmailService;
import org.wl.service.UsersService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TouziPojAction extends ActionSupport{
	private TouziPoj p = new TouziPoj();
	private Page pp=new Page();
	TouziPojService s=new TouziPojService();
	private List<TouziPoj> poj;
	Users u = new Users();
	UsersService us = new UsersService();
	CyTPoj c=new CyTPoj();
	CyTPojService cs=new CyTPojService();
	List<CyTPoj> cl;
	TouziState r1=new TouziState();
	TouziType r2=new TouziType();
	TouziStateService s1=new TouziStateService();
	TouziTypeService s2=new TouziTypeService();
	List stateList=s1.findAll();
	List typeList=s2.findAll();
	List typeListke=s2.findAllke();
	private File mypic;
	private String mypicFileName;
	private File myfile;
	private String myfileFileName;
	private double tzmoney;
	private UsersEmail e=new UsersEmail();
	private UsersEmailService es=new UsersEmailService();
	
	public List getStateList() {
		return stateList;
	}

	public void setStateList(List stateList) {
		this.stateList = stateList;
	}

	public List getTypeList() {
		return typeList;
	}

	public void setTypeList(List typeList) {
		this.typeList = typeList;
	}

	public UsersEmail getE() {
		return e;
	}

	public void setE(UsersEmail e) {
		this.e = e;
	}

	public Page getPp() {
		return pp;
	}

	public void setPp(Page pp) {
		this.pp = pp;
	}

	public double getTzmoney() {
		return tzmoney;
	}

	public void setTzmoney(double tzmoney) {
		this.tzmoney = tzmoney;
	}
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public TouziPoj getP() {
		return p;
	}

	public void setP(TouziPoj p) {
		this.p = p;
	}

	public List<TouziPoj> getPoj() {
		return poj;
	}

	public void setPoj(List<TouziPoj> poj) {
		this.poj = poj;
	}

	public Users getU() {
		return u;
	}

	public void setU(Users u) {
		this.u = u;
	}

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

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public void validateSave(){
		System.out.println("validatesave11111111111111111");
		if(p.getName()==null||"".equals(p.getName())){
			this.addFieldError("p.name", "项目名称不能为空");
		}if(p.getPeriod()==null||"".equals(p.getPeriod())){
			this.addFieldError("p.name", "投资期限不能为空");
		}if(r2.getId()==null||"".equals(r2.getId())){
			this.addFieldError("p.name", "请选择投资类型");
		}if(p.getMoney()==null||"".equals(p.getMoney())){
			this.addFieldError("p.name", "目标投资金额不能为空");
		}
	}
	public void validateUpdate(){
		System.out.println("validatesave1------------update");
		System.out.println("p.preriod---------"+p.getPeriod()+"-----");
		System.out.println(p.getPeriod()==null);
		System.out.println("".equals(p.getPeriod()));
		System.out.println(p.getName()+"   "+p.getPojid()+"'''''"+p.getMoney()+"         "+r2.getId()+"              "+u.getUserid());
		if(p.getName()==null||"".equals(p.getName())){
			this.addFieldError("p.name", "项目名称不能为空");
		}if(p.getPeriod()==null||"".equals(p.getPeriod())){
			this.addFieldError("p.name", "投资期限不能为空");
		}if(r2.getId()==null||"".equals(r2.getId())){
			this.addFieldError("p.name", "请选择投资类型");
		}if(p.getMoney()==null||"".equals(p.getMoney())){
			this.addFieldError("p.name", "目标投资金额不能为空");
		}
		System.out.println("jiaoyan jieshu ------------");
	}
	public void validateZancun(){
		System.out.println("validatesave11111111111111111");
		if(p.getName()==null||"".equals(p.getName())){
			this.addFieldError("p.name", "项目名称不能为空");
		}if(r2.getId()==null||"".equals(r2.getId())){
			this.addFieldError("p.name", "请选择投资类型");
		}
	}
	public void validateUpzancun(){
		System.out.println("validatesave11111111111111111");
		if(p.getName()==null||"".equals(p.getName())){
			this.addFieldError("p.name", "项目名称不能为空");
		}if(r2.getId()==null||"".equals(r2.getId())){
			this.addFieldError("p.name", "请选择投资类型");
		}
	}
	//用户创建项目
	public String save(){
		try{
			TouziTypeDAO d2=new TouziTypeDAO();
			TouziStateDAO d1=new TouziStateDAO();
			UsersDAO d3 = new UsersDAO();
			String userid=u.getUserid();//获得当前登录的用户id
			int style1 = r2.getId();//ty
			p.TouziPoj(d1.findById(1),d2.findById(style1),d3.findById(userid));	//构造方法
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date0=Timestamp.valueOf(df.format(date));
			p.setStarttime(date0);
			p.setRequesttime(date0);
		    if(mypic==null){// 如果没有上传图片  就不存mypic
				if(myfile==null){//如果没上传图片 、文件
					if(s.save(p)){
						return "save";
					}else{
						return "fail";
					}
				}//如果没图片you文件
				String savefileName="doc/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.myfileFileName);
				String savefilePath=ServletActionContext.getServletContext().getRealPath(savefileName);
				FileInputStream input1=new FileInputStream(myfile);
				FileOutputStream output1=new FileOutputStream(savefilePath);
				p.setBy1(savefileName);
				if(s.save(p)){
					IOUtils.copy(input1, output1);
					output1.flush();
					input1.close();
					output1.close();
					return "save";
				}else{return "fail";}
			}else{// 图片上传了
				if(myfile==null){//图片有、无文件
					String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
					String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
					FileInputStream input=new FileInputStream(mypic);
					FileOutputStream output=new FileOutputStream(savePath);
					p.setIcon(saveName);
					if(s.save(p)){
						IOUtils.copy(input, output);
						output.flush();
						input.close();
						output.close();
						return "save";
					}else{
						return "fail";
					}
				}
				String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
				String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
				String savefileName="doc/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.myfileFileName);
				String savefilePath=ServletActionContext.getServletContext().getRealPath(savefileName);
				FileInputStream input=new FileInputStream(mypic);
				FileOutputStream output=new FileOutputStream(savePath);
				p.setIcon(saveName);
				FileInputStream input1=new FileInputStream(myfile);
				FileOutputStream output1=new FileOutputStream(savefilePath);
				p.setBy1(savefileName);
				if(s.save(p)){
					IOUtils.copy(input, output);
					output.flush();
					input.close();
					output.close();
					IOUtils.copy(input1, output1);
					output1.flush();
					input1.close();
					output1.close();
					return "save";
				}else{
					return "fail";
				}
			}
		}catch(Exception e){e.printStackTrace();return "fail";}		
	}
	//zancun
	public String zancun(){
		try{
			TouziTypeDAO d2=new TouziTypeDAO();
			TouziStateDAO d1=new TouziStateDAO();
			System.out.println("================="+p.getName());
			UsersDAO d3 = new UsersDAO();
			String userid=u.getUserid();//获得当前登录的用户id
			int style1 = r2.getId();//ty
			System.out.println("type=================="+r2.getId());
			p.TouziPoj(d1.findById(1),d2.findById(style1),d3.findById(userid));	//构造方法
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date0=Timestamp.valueOf(df.format(date));
			p.setStarttime(date0);
			p.setRequesttime(date0);
			if("".equals(p.getPeriod())||p.getPeriod()==null){
				p.setPeriod("0");
			}
			if("".equals(p.getMoney())||p.getMoney()==null){
				p.setMoney(0.0);
			}
			
		    if(mypic==null){// 如果没有上传图片  就不存mypic
				if(myfile==null){//如果没上传图片 、文件
					p.setTouziState(s1.findById(10));
					if(s.save(p)){
						return "zancun";
					}else{
						return "fail";
					}
				}//如果没图片you文件
				String savefileName="doc/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.myfileFileName);
				String savefilePath=ServletActionContext.getServletContext().getRealPath(savefileName);
				FileInputStream input1=new FileInputStream(myfile);
				FileOutputStream output1=new FileOutputStream(savefilePath);
				p.setBy1(savefileName);
				p.setTouziState(s1.findById(10));
				if(s.save(p)){
					IOUtils.copy(input1, output1);
					output1.flush();
					input1.close();
					output1.close();
					return "zancun";
				}else{return "fail";}
			}else{// 图片上传了
				if(myfile==null){//图片有、无文件
					String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
					String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
					FileInputStream input=new FileInputStream(mypic);
					FileOutputStream output=new FileOutputStream(savePath);
					p.setTouziState(s1.findById(10));
					p.setIcon(saveName);
					if(s.save(p)){
						IOUtils.copy(input, output);
						output.flush();
						input.close();
						output.close();
						return "zancun";
					}else{
						return "fail";
					}
				}
				String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
				String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
				String savefileName="doc/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.myfileFileName);
				String savefilePath=ServletActionContext.getServletContext().getRealPath(savefileName);
				FileInputStream input=new FileInputStream(mypic);
				FileOutputStream output=new FileOutputStream(savePath);
				p.setIcon(saveName);
				FileInputStream input1=new FileInputStream(myfile);
				FileOutputStream output1=new FileOutputStream(savefilePath);
				p.setBy1(savefileName);
				p.setTouziState(s1.findById(10));
				if(s.save(p)){
					IOUtils.copy(input, output);
					output.flush();
					input.close();
					output.close();
					IOUtils.copy(input1, output1);
					output1.flush();
					input1.close();
					output1.close();
					return "zancun";
				}else{
					return "fail";
				}
			}
		}catch(Exception e){e.printStackTrace();return "fail";}		
	}
	
	//update  zancun
	public String upzancun(){
		try{
			System.out.println("update-----------zancun-------------");
			TouziTypeDAO d2=new TouziTypeDAO();
			TouziStateDAO d1=new TouziStateDAO();
			UsersDAO d3 = new UsersDAO();
			String userid=u.getUserid();// 用户id
			int style1 = r2.getId();//type
			p.TouziPoj(d1.findById(10),d2.findById(style1),d3.findById(userid));
			TouziPoj pp=new TouziPoj();
			pp=s.findById(p.getPojid());//当前项目
			System.out.println("icon----------------icon"+pp.getIcon()+"userid"+userid+style1);
			//p.setIcon(pp.getIcon());
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date0=Timestamp.valueOf(df.format(date));
			p.setStarttime(date0);
			p.setRequesttime(date0);
			if("".equals(p.getPeriod())||p.getPeriod()==null){
				p.setPeriod("0");
			}
			if("".equals(p.getMoney())||p.getMoney()==null){
				p.setMoney(0.0);
			}p.setNowmoney(0.0);
			if(mypic==null){
				if(myfile==null){
					// pic\file 全为空
					p.setIcon(pp.getIcon());
					p.setBy1(pp.getBy1());
					if(s.update(p)){
						return "upzancun";
					}else{
						return "fail";
					}			
				}
			    // pic 为空 file不为空
				String savefileName="doc/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.myfileFileName);
				System.out.println("name"+savefileName);
				String savefilePath=ServletActionContext.getServletContext().getRealPath(savefileName);
				System.out.println("path"+savefilePath);
				FileInputStream input1=new FileInputStream(myfile);
				FileOutputStream output1=new FileOutputStream(savefilePath);
				p.setIcon(pp.getIcon());
				p.setBy1(savefileName);
				if(s.update(p)){
					IOUtils.copy(input1, output1);
					output1.flush();
					input1.close();
					output1.close();
					return "upzancun";
				}else{
					return "fail";
					}		
			}else{//pic 不为空
				if(myfile==null){//file 为空
					String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
					System.out.println("name"+saveName);
					String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
					System.out.println("path"+savePath);
					FileInputStream input=new FileInputStream(mypic);
					FileOutputStream output=new FileOutputStream(savePath);
					//p.setIcon(pp.getIcon());
					p.setBy1(pp.getBy1());
					p.setIcon(saveName);
					if(s.update(p)){
						IOUtils.copy(input, output);
						output.flush();
						input.close();
						output.close();
						return "upzancun";
					}else{
						return "fail";
						}	
				}
				//pic\file都不为空
				String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
				System.out.println("name"+saveName);
				String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
				System.out.println("path"+savePath);
				String savefileName="doc/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.myfileFileName);
				System.out.println("name"+savefileName);
				String savefilePath=ServletActionContext.getServletContext().getRealPath(savefileName);
				System.out.println("path"+savefilePath);
				FileInputStream input=new FileInputStream(mypic);
				FileOutputStream output=new FileOutputStream(savePath);
				p.setIcon(saveName);
				FileInputStream input1=new FileInputStream(myfile);
				FileOutputStream output1=new FileOutputStream(savefilePath);
				p.setBy1(savefileName);
				if(s.update(p)){
					IOUtils.copy(input, output);
					output.flush();
					input.close();
					output.close();
					IOUtils.copy(input1, output1);
					output1.flush();
					input1.close();
					output1.close();
					return "upzancun";
				}else{
					return "fail";
					}			
			}
					
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}	
	}
	//用户查看项目详情
	public String look(){
		try{
		p=s.findById(p.getPojid());
		return "look";}
		catch(Exception e){
			return "fail";
		}
	}
	public String money(){
		try{
			int pojid=p.getPojid();
			p=s.findById(pojid);
			return "money";
		}catch(Exception e){
			return "fail";
		}
	}
	@SuppressWarnings("unchecked")
	public String test(){
		try{
			System.out.println("test方法");
			Integer rr1=(Integer) ActionContext.getContext().getSession().get("rr1");
			 Integer rr2=(Integer) ActionContext.getContext().getSession().get("rr2");
			 String name2=(String) ActionContext.getContext().getSession().get("name2");
			List rpoj=(List<TouziPoj>) ActionContext.getContext().getSession().get("rpoj");
			String userid=u.getUserid();
			System.out.println("rr1==="+rr1);
			System.out.println(rr1+" 444 "+rr2+" 555  "+name2+"  666 ");
			pp.setPageSize(2);
			pp.setRowCount(s.getRowByTitle(userid,name2,rr1,rr2));
			System.out.println("pageCount   "+pp.getPageCount());
			System.out.println("page   "+pp.toString());
			System.out.println("r1  "+rr1+"====r2==="+rr2);
			System.out.println(s.getRowByTitle(userid,name2,rr1,rr2));
			rpoj=s.findAllByTitle(pp.getCurrentPage(),pp.getPageSize(),userid,name2,rr1,rr2);				
			poj=rpoj;
			ActionContext.getContext().getSession().put("rr1",rr1);//state
			ActionContext.getContext().getSession().put("rr2",rr2);
			ActionContext.getContext().getSession().put("rpoj",rpoj);
			System.out.println(rpoj.toString());
			return "test";
		
	}catch(Exception e){
		System.out.println("error");
		return "fail";}
	}
	//用户筛选项目
	public String findAllByTitle(){
		try{
				String userid=u.getUserid();
				System.out.println("userid   "+userid);
				Integer r11=r1.getId();//state
				Integer r22=r2.getId();
				String name=p.getName();
				pp.setPageSize(2);
				pp.setRowCount(s.getRowByTitle(userid,name,r11,r22));
				System.out.println("page   "+pp.toString());
				System.out.println("r1  "+r11+"====r2==="+r22);
				System.out.println("符合 条件：  "+s.getRowByTitle(userid,name,r11,r22));
				poj=s.findAllByTitle(pp.getCurrentPage(),pp.getPageSize(),userid,name,r11,r22);
				ActionContext.getContext().getSession().put("rr1",r11);//state
				ActionContext.getContext().getSession().put("rr2",r22);
				ActionContext.getContext().getSession().put("rpoj",poj);
				ActionContext.getContext().getSession().put("name2",name);
				System.out.println(poj.toString());
				return "findAllByTitle";
		}catch(Exception e){
			System.out.println("error");
			return "fail";}
	}
	
	//游客筛选项目
	public String yfindByTitle(){
		try{
			
			Integer r11=r1.getId();//state
			Integer r22=r2.getId();//type
			//typeList=getTypeList();
			System.out.println("typeList==========="+typeList);
			String name=p.getName();
			System.out.println("find youke by title:"+name);
			pp.setPageSize(2);
			pp.setRowCount(s.getyRowByTitle(name,r11,r22));
			System.out.println("page   "+pp.toString());
			System.out.println("r1  "+r11+"====r2==="+r22);
			System.out.println("符合 条件：  "+s.getyRowByTitle(name,r11,r22));
			poj=s.yfindAllByTitle(pp.getCurrentPage(),pp.getPageSize(),name,r11,r22);
			ActionContext.getContext().getSession().put("rr1",r11);//state
			ActionContext.getContext().getSession().put("rr2",r22);
			ActionContext.getContext().getSession().put("rpoj",poj);
			ActionContext.getContext().getSession().put("name2",name);
			System.out.println(poj.toString());
			return "yfindByTitle";
		
	}catch(Exception e){
		System.out.println("error");
		return "fail";}
		
	}
	public CyTPoj getC() {
		return c;
	}

	public void setC(CyTPoj c) {
		this.c = c;
	}

	public List<CyTPoj> getCl() {
		return cl;
	}

	public void setCl(List<CyTPoj> cl) {
		this.cl = cl;
	}

	@SuppressWarnings("unchecked")
	public String test1(){
		try{
			System.out.println("-----------------test1方法");
			Integer rr1=(Integer) ActionContext.getContext().getSession().get("rr1");
			Integer rr2=(Integer) ActionContext.getContext().getSession().get("rr2");
			List rpoj=(List<TouziPoj>) ActionContext.getContext().getSession().get("rpoj");
			String name2=(String) ActionContext.getContext().getSession().get("name2");
			System.out.println("rr1==="+rr1);
			System.out.println(rr1+" 444 "+rr2+" 555  "+name2+"  666 ");
			pp.setPageSize(2);
			pp.setRowCount(s.getyRowByTitle(name2,rr1,rr2));
			System.out.println("pageCount   "+pp.getPageCount());
			System.out.println("page   "+pp.toString());
			System.out.println("r1  "+rr1+"====r2==="+rr2);
			System.out.println(s.getyRowByTitle(name2,rr1,rr2));
			rpoj=s.yfindAllByTitle(pp.getCurrentPage(),pp.getPageSize(),name2,rr1,rr2);				
			poj=rpoj;
			ActionContext.getContext().getSession().put("rr1",rr1);//state
			ActionContext.getContext().getSession().put("rr2",rr2);
			ActionContext.getContext().getSession().put("rpoj",rpoj);
			System.out.println(rpoj.toString());
			return "test1";
		
	}catch(Exception e){
		System.out.println("error");
		return "fail";}
	}
	public String yjubao(){
		try{
			int pojid=p.getPojid();
			p=s.findById(pojid);
			p.setTouziState(s1.findById(8));
			s.update(p);
			String text="您发布的“"+p.getName()+"”项目被举报了，请检查您的内容！";
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date0=Timestamp.valueOf(df.format(date));
			e.setBy1(date0);
			e.UsersEmail(p.getUsers().getUserid(),text, 0);
			e.setHead("投资项目被举报");
			es.add(e);
			return "yjubao";
		}catch(Exception e){
			return "fail";}
	}
	
	
	
	//管理员 通过项目--
	public String tong(){
		try{
			int pojid=p.getPojid();
			p=s.findById(pojid);
			p.setTouziState(s1.findById(2));
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date0=Timestamp.valueOf(df.format(date));
			p.setStarttime(date0);
			s.update(p);
			String text="您的“"+p.getName()+"”项目已经通过审核了！";
			e.setBy1(date0);
			e.UsersEmail(p.getUsers().getUserid(),text, 0);
			e.setHead("投资项目通过审核");
			es.add(e);
			this.addActionMessage("操作成功！");
			return "tong";
		}catch(Exception e){
			return "fail";}
	}
	
	//管理员 删除项目
	public String delete(){
		try{
			int pojid=p.getPojid();
			cl=cs.findByPojid(pojid);//users
			int co=cl.size();
			System.out.println("cl nember==---"+co);
			int i=0;
			System.out.println("delete before");
			String text0="您的“"+s.findById(pojid).getName()+"”项目已经删除！";
			Date date11=new Date();
			SimpleDateFormat df11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date00=Timestamp.valueOf(df11.format(date11));
			e.setBy1(date00);
			e.setHead("投资项目被删除");
			e.UsersEmail(s.findById(pojid).getUsers().getUserid(),text0, 0);
			es.add(e);
			System.out.println(e.toString());
			while(i<co){
				System.out.println("shuru i");	
				String uuserid=cl.get(i).getUsers().getUserid();//每个用户id
				System.out.println("uuuserid+++++"+uuserid);
				double mmoney=cl.get(i).getMoney();//项目中 融资的钱
				u=us.findById(uuserid);//每个用户
				System.out.println("cytpoj 的钱  -----------"+mmoney);//融资的钱 string化
				System.out.println("原来user的钱----------------"+u.getMoney());
				u.setMoney(u.getMoney()+mmoney);
				us.update(u);
				
				System.out.println(" 删除后 user  的钱----=="+u.getMoney());
				String pojname=s.findById(pojid).getName();//项目名
				String text="您参与的”"+pojname+"“项目已经删除，投资资金已返还给您，请注意账户余额！";
				Date date=new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Timestamp date0=Timestamp.valueOf(df.format(date));
				e.setBy1(date0);
				e.setHead("参与的投资项目被删除");
				e.UsersEmail(uuserid,text, 0);
				es.add(e);
				i++;
				System.out.println("en");
			}
			
			System.out.println(pojid);
			p=s.findById(p.getPojid());
			s.delete(p);
			this.addActionMessage("操作成功！");
			return "delete";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	
	//管理员 筛选
	public String adminfindall(){

		try{
			System.out.println("adminfindall--------------");

			Integer r11=r1.getId();//state
			Integer r22=r2.getId();//type
			String name=p.getName();
			pp.setPageSize(2);
			pp.setRowCount(s.getadRowByTitle(name,r11,r22));
			System.out.println("page   "+pp.toString());
			System.out.println("r1  "+r11+"====r2==="+r22);
			System.out.println("符合 条件：  "+s.getadRowByTitle(p.getName(),r11,r22));
			poj=s.adfindAllByTitle(pp.getCurrentPage(),pp.getPageSize(),name,r11,r22);
			ActionContext.getContext().getSession().put("rr1",r11);//state
			ActionContext.getContext().getSession().put("rr2",r22);
			ActionContext.getContext().getSession().put("name2",name);
			ActionContext.getContext().getSession().put("rpoj",poj);
			System.out.println(poj.toString());
			return "adminfindall";
	}catch(Exception e){
		System.out.println("error");
		return "fail";}
		
	}
	public String test0(){
		try{
			System.out.println("-----------------test1方法");
			Integer rr1=(Integer) ActionContext.getContext().getSession().get("rr1");
			Integer rr2=(Integer) ActionContext.getContext().getSession().get("rr2");
			List<TouziPoj> rpoj;//=(List<RongziPoj>) ActionContext.getContext().getSession().get("rpoj");
			String name2=(String) ActionContext.getContext().getSession().get("name2");
			//String userid=u.getUserid();
			System.out.println("rr1==="+rr1);
			System.out.println(rr1+" 444 "+rr2+" 555  "+name2+"  666 ");
			pp.setPageSize(2);
			pp.setRowCount(s.getadRowByTitle(name2,rr1,rr2));
			System.out.println("pageCount   "+pp.getPageCount());
			System.out.println("page   "+pp.toString());
			System.out.println("r1  "+rr1+"====r2==="+rr2);
			System.out.println(s.getadRowByTitle(name2,rr1,rr2));
			rpoj=s.adfindAllByTitle(pp.getCurrentPage(),pp.getPageSize(),name2,rr1,rr2);		
			System.out.println("curre======-----------------================="+pp.getCurrentPage());
			poj=rpoj;
			ActionContext.getContext().getSession().put("rr1",rr1);//state
			ActionContext.getContext().getSession().put("rr2",rr2);
			ActionContext.getContext().getSession().put("name2",name2);
			ActionContext.getContext().getSession().put("rpoj",rpoj);
			
			System.out.println(rpoj.toString());
			return "test0";
		
	}catch(Exception e){
		System.out.println("error");
		return "fail";}
	}
	//管理员 拒绝项目
	public String jujue(){
		try{
			int pojid=p.getPojid();
			p=s.findById(pojid);
			p.setTouziState(s1.findById(5));////////////////////////////////////////////////////////////////////////
			s.update(p);
			String text="您发布的“"+p.getName()+"”项目审核未被通过，您可以前去查看！";
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date0=Timestamp.valueOf(df.format(date));
			e.setBy1(date0);
			e.UsersEmail(p.getUsers().getUserid(),text, 0);
			e.setHead("投资项目被拒绝");
			es.add(e);
			this.addActionMessage("操作成功！");
			return "jujue";
		}catch(Exception e){
			return "fail";}
	}
	//用户 修改项目信息
	public String toupdate(){
		try{
			p=s.findById(p.getPojid());
			System.out.println("to update----------------"+p.getPojid());
			return "toupdate";
	    }catch(Exception e){
			return "fail";
		}
	}
	public String update(){
		System.out.println("update-------------------tijiao   "+p.getPojid());
		try{
			TouziTypeDAO d2=new TouziTypeDAO();
			TouziStateDAO d1=new TouziStateDAO();
			UsersDAO d3 = new UsersDAO();
			String userid=u.getUserid();// 用户id
			int style1 = r2.getId();//type
			p.TouziPoj(d1.findById(1),d2.findById(style1),d3.findById(userid));
			TouziPoj pp=new TouziPoj();
			pp=s.findById(p.getPojid());//当前项目
			System.out.println(pp.getIcon());
			p.setNowmoney(0.0);
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp date0=Timestamp.valueOf(df.format(date));
			p.setRequesttime(p.getRequesttime());
			p.setStarttime(date0);
			//p.setIcon(pp.getIcon());
			if(mypic==null){
				if(myfile==null){
					// pic\file 全为空
					p.setIcon(pp.getIcon());
					p.setBy1(pp.getBy1());
					if(s.update(p)){
						return "update";
					}else{
						System.out.println("ppppppppppppppppppppppppp");
						return "fail";
					}			
				}
			    // pic 为空 file不为空
				String savefileName="doc/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.myfileFileName);
				System.out.println("name"+savefileName);
				String savefilePath=ServletActionContext.getServletContext().getRealPath(savefileName);
				System.out.println("path"+savefilePath);
				FileInputStream input1=new FileInputStream(myfile);
				FileOutputStream output1=new FileOutputStream(savefilePath);
				p.setIcon(pp.getIcon());
				p.setBy1(savefileName);
				if(s.update(p)){
					IOUtils.copy(input1, output1);
					output1.flush();
					input1.close();
					output1.close();
					return "update";
				}else{
					System.out.println("eeeeeeeeeeeeeeeeeeeee");
					return "fail";
					}		
			}else{//pic 不为空
				if(myfile==null){//file 为空
					String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
					System.out.println("name"+saveName);
					String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
					System.out.println("path"+savePath);
					FileInputStream input=new FileInputStream(mypic);
					FileOutputStream output=new FileOutputStream(savePath);
					//p.setIcon(pp.getIcon());
					p.setBy1(pp.getBy1());
					p.setIcon(saveName);
					if(s.update(p)){
						IOUtils.copy(input, output);
						output.flush();
						input.close();
						output.close();
						return "update";
					}else{
						System.out.println("wwwwwwwwwwwwwwwwww");
						return "fail";
						}	
				}
				//pic\file都不为空
				String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
				System.out.println("name"+saveName);
				String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
				System.out.println("path"+savePath);
				String savefileName="doc/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.myfileFileName);
				System.out.println("name"+savefileName);
				String savefilePath=ServletActionContext.getServletContext().getRealPath(savefileName);
				System.out.println("path"+savefilePath);
				FileInputStream input=new FileInputStream(mypic);
				FileOutputStream output=new FileOutputStream(savePath);
				p.setIcon(saveName);
				FileInputStream input1=new FileInputStream(myfile);
				FileOutputStream output1=new FileOutputStream(savefilePath);
				p.setBy1(savefileName);
				if(s.update(p)){
					IOUtils.copy(input, output);
					output.flush();
					input.close();
					output.close();
					IOUtils.copy(input1, output1);
					output1.flush();
					input1.close();
					output1.close();
					return "update";
				}else{
					System.out.println("ssssssssssssssssssssss");
					return "fail";
					}			
			}
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}	
	}
	public void state(){//用来更新项目的融资状态  
		/*
		 * 如果当前日期-开始融资日期>=融资期限则 更改状态为4 ，融资结束*/
			TouziPojDAO dd=new TouziPojDAO();
			List pp=dd.findAllstate();
			Date date=new Date();//当前日期
			int t=pp.size();
			System.out.println(t);
			try {
				int i=0;
			while(i<t){
					Date dda=((TouziPoj) pp.get(i)).getStarttime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date start;
					Date date0;
					start = sdf.parse(sdf.format(dda));//开始融资的日期
					System.out.println("开始投资："+start);
					date0 = sdf.parse(sdf.format(date));//当前日期
					System.out.println("当前日期："+date0);
					int days=Integer.parseInt(((TouziPoj)pp.get(i)).getPeriod());//融资期限
					System.out.println("期限"+days);
					Calendar cal = Calendar.getInstance();
					cal.setTime(start);
					long time1 = cal.getTimeInMillis();//开始融资的日期
					cal.setTime(date0);//当前日期
					long time2 = cal.getTimeInMillis();//当前日期
					long between_days = (time2 - time1) / (1000 * 3600 * 24);
					int cha= Integer.parseInt(String.valueOf(between_days));//发布项目一共几天
					System.out.println("发布几天"+cha);
					if(cha-days>=0){
						System.out.println(cha-days);
						TouziStateService po=new TouziStateService();//state service
						//RongziState sa=new RongziState();
						System.out.println(pp.get(i));
						TouziPoj ppp=new TouziPoj();
						ppp=(TouziPoj) pp.get(i);
						ppp.setTouziState(po.findById(4));
						s.update(ppp);
						System.out.println(pp.get(i));
					}
					    i++;
				}
			}		
			 catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	}

		
		
				
		
	public String nowmoney(){
		try{
		p=s.findById(p.getPojid());//RongziPoj
		double pojmoney=p.getMoney();
		System.out.println("项目目标投资金额  "+pojmoney);
		double pojnowmoney=p.getNowmoney();
		System.out.println("项目现在投资金额  "+pojnowmoney);
		UsersService ss=new UsersService();
		u=ss.findById(u.getUserid());
		double usermoney = u.getMoney();
		System.out.println("用户余额  "+usermoney);
		System.out.println("用户要参与的金额  "+tzmoney);
		double xumoney=pojmoney-pojnowmoney;
		System.out.println("项目需要的最大金额  "+xumoney);
		if(pojmoney>pojnowmoney){//如果融资没满
			if(usermoney>=tzmoney){//如果余额足够
				if(tzmoney<=xumoney){//如果用户参与的金额 在 项目需要的金额内
					pojnowmoney+=tzmoney;
					usermoney-=tzmoney;
					System.out.println("pojnowmoney="+pojnowmoney+"    usermoney="+usermoney);
					u.setMoney(usermoney);//用户剩余的钱
					p.setNowmoney(pojnowmoney);//项目的现有资金
					ss.update(u);
					s.update(p);
					System.out.println("poj  "+p.getPojid()+"u  "+u.getUserid()+"poj now  "+p.getNowmoney());
					cl=cs.findBypu(p.getPojid(),u.getUserid());
					if(cl.size()==0){
						System.out.println("null");
						c.CyTPoj(p, u,tzmoney);
						cs.update(c);
						System.out.println(c.toString());
						System.out.println("poj  "+p.getPojid()+"u  "+u.getUserid()+"poj now  "+p.getNowmoney());
						Date date=new Date();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Timestamp date0=Timestamp.valueOf(df.format(date));
						e.setBy1(date0);
						String text="您发布的“"+p.getName()+"”项目已经有用户“"+u.getUserid()+"”参与投资了，快去查看进度吧！";
						e.setHead("投资项目有参与者");
						e.UsersEmail(p.getUsers().getUserid(),text, 0);
						es.add(e);
						System.out.println("tongzhi  email--------------"+p.getUsers().getUserid());
						this.addFieldError("tzmoney", "您参与投资成功！");
					}else{
						System.out.println("not null");
						c=cl.get(0);
						tzmoney=tzmoney+c.getMoney();
						c.CyTPoj(p, u,tzmoney);
						cs.update(c);
						System.out.println("poj  "+p.getPojid()+"u  "+u.getUserid()+"poj now  "+p.getNowmoney());
						String text="您发布的“"+p.getName()+"”项目已经有用户“"+u.getUserid()+"”参与投资了，快去查看进度吧！";
						Date date=new Date();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Timestamp date0=Timestamp.valueOf(df.format(date));
						e.setBy1(date0);
						e.setHead("投资项目有参与者");
						e.UsersEmail(p.getUsers().getUserid(),text, 0);
						es.add(e);
						this.addFieldError("tzmoney", "您参与投资成功！");
					}
					
				}else{// 用户参与金额 大于 需要的金额  ， 最大参与额度
					System.out.println("目前最大参与额度为 "+xumoney+"元");

					this.addFieldError("tzmoney", "您输入的金额大于项目目前所需金额  "+"  目前最大参与额度为 "+xumoney+"元");
				}
			}else{//如果余额不足
				this.addFieldError("tzmoney", "您的余额不足");
			}
		}else{//如果融资已满   ，最多参与融资额度
			this.addFieldError("tzmoney", "投资已满");
		}
		return "nowmoney";
	}catch(Exception e){
		
		return "fail";
	}
	}
	public List getTypeListke() {
		return typeListke;
	}

	public void setTypeListke(List typeListke) {
		this.typeListke = typeListke;
	}

	public String tcreate(){
		System.out.println(typeListke.size());
		int i=0;
		while(i<typeListke.size()){
			System.out.println(typeListke.get(i).toString());
			i++;
		}
		return "tcreate";
	}
}
