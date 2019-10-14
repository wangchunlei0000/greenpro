package org.wl.action;

import org.apache.commons.lang.StringUtils;
import org.g.action.CyTPojAction;
import org.g.action.TouziPojAction;
import org.wl.dao.UsersDAO;
import org.wl.pojo.Logins;
import org.wl.pojo.Users;
import org.wl.pojo.UsersEmail;
import org.wl.service.LoginsService;
import org.wl.service.UsersEmailService;
import org.wl.service.UsersService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginsAction extends ActionSupport{

	LoginsService s = new LoginsService();
	private Logins o = new Logins();
	private String repwd;
	private String ids;
	private UsersEmail e=new UsersEmail();
	private UsersEmailService es=new UsersEmailService();
	private String newpwd;
	private String rnewpwd;
	private String email;
	Users u=new Users();
	UsersService us=new UsersService();
	public Users getU() {
		return u;
	}
	public void setU(Users u) {
		this.u = u;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getRnewpwd() {
		return rnewpwd;
	}
	public void setRnewpwd(String rnewpwd) {
		this.rnewpwd = rnewpwd;
	}
	public UsersEmail getE() {
		return e;
	}
	public void setE(UsersEmail e) {
		this.e = e;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public LoginsService getS() {
		return s;
	}
	public void setS(LoginsService s) {
		this.s = s;
	}
	public Logins getO() {
		return o;
	}
	public void setO(Logins o) {
		this.o = o;
	}
	public String disEnableBatch(){
		if(ids==null||"".equals(ids)){
			return "ko";
			//this.addFieldError("o.ko", "您未选中用户！");
		}else{
		String X = "'" + StringUtils.join(ids.split(", "),"','")+"'";
		if(s.disEnableBatch("1",X)>0){//flag=1
			this.addActionMessage("更新成功！");
		}
		return "disEnableBatch";}
		
	} 
	
	public String enableBatch(){
		if(ids==null||"".equals(ids)){
			return "ko";
		}else{
		String X = "'" + StringUtils.join(ids.split(", "),"','")+"'";
		if(s.enableBatch("0",X)>0){
			this.addActionMessage("更新成功！");
		}
		return "enableBatch";}
		
		}
		
	
	public void validateReg(){
		//System.out.println("email"+email);
	if(o.getUserid()==null||o.getUserid().equals("")){
			this.addFieldError("o.userid", "账号不能为空！请输入！");
			//this.addActionMessage("账号不能为空！请输入！");
		}else if(email==null||"".equals(email)){
			this.addFieldError("o.pwd", "邮箱不能为空！请输入！");
		}
		else if(email!=null&&!"".equals(email)){
			String regex = "(\\w{3,10}\\.)*\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
			if(!email.matches(regex)){
	    		System.out.println("bu pi pei");
	    		this.addFieldError("o.pwd", "您输入的邮箱地址不正确！");
	    	}
		}else if(o.getPwd()==null||o.getPwd().equals("")){
			this.addFieldError("o.pwd", "密码不能为空！请输入！");
		}else if(repwd==null||repwd.equals("")){
			this.addFieldError("repwd", "确认密码不能为空！请输入！");
		}else if(!repwd.equals(o.getPwd())){
			this.addFieldError("repwd", "两次密码不一致请重新输入！");
		}
		else if (email!=null&!"".equals(email)){//邮箱验证
	    	System.out.println("email jiaoyan");
	    	String regex = "(\\w{3,10}\\.)*\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
	    	//String email=o.getEmail();
	    	if(!email.matches(regex)){
	    		System.out.println("bu pi pei");
	    		this.addFieldError("o.pwd", "您输入的邮箱地址不正确！");
	    	}
	    }
		
	}
	
	public String login(){
		String r=this.LOGIN;
		Logins o1=s.findById(o.getUserid());
		if(o.getUserid()==null||o.getUserid().equals("")){
			this.addActionMessage("账号不能为空！");
		}else if(o.getPwd()==null||o.getPwd().equals("")){
			this.addActionMessage("密码不能为空！");
		}else if(o1==null){
			this.addActionMessage("不存在此账户！");
		}else if(o1.getEnable().equals("1")){
			this.addActionMessage("您的账户不可用！");
		}else if(!o1.getPwd().equals(o.getPwd())){
			this.addActionMessage("密码输入错误！");
		}else{
			if(o1.getRole().equals("0")){
				
				r="users";
			}else if(o1.getRole().equals("1")){
				
				r="admin";
			}
			String userid1=o1.getUserid();
			ActionContext.getContext().getSession().put("userid",userid1);
			String role1=o1.getRole();
			ActionContext.getContext().getSession().put("role",role1);
			RongziPojAction rr=new RongziPojAction();
			rr.state();
			TouziPojAction rrr=new TouziPojAction();
			rrr.state();
			CyTPojAction c=new CyTPojAction();
			c.state();
		}
		return r;
		
	}
	public String tuichu(){
		try{
			ActionContext.getContext().getSession().clear();
			ActionContext.getContext().getSession().clear();
			return "tuichu";
		}catch(Exception e){
			return "fail";
		}
		
	}
	public String reg(){
		String r=this.INPUT;
		Logins o1=s.findById(o.getUserid());
		if(o1==null){
			if(s.add(o)){
			this.addActionMessage("注册成功，赶快登录吧！");
			UsersDAO ud=new UsersDAO();
			Users u=new Users();
			u.setUserid(o.getUserid());
			u.setEmail(email);
			u.setSex("0");
			ud.save(u);
			r=this.LOGIN;}
			else{
			r=this.INPUT;
			}
			//return r;
		}else{
			this.addFieldError("o.userid", "已存在此账号！");
			r = this.INPUT;
		}
		return r;

	}
	public String findById(){
		System.out.println(o.getUserid().toString());
		o=s.findById(o.getUserid());
		return "findById";
	}
	public String topwd(){
		System.out.println(o.getUserid().toString());
		o=s.findById(o.getUserid());
		return "topwd";
	}
	@SuppressWarnings("finally")
	public String pwd(){
		String r = "input";
		try{
			String userid=o.getUserid();
			System.out.println(userid);
			String password=o.getPwd();
			System.out.println(password);
			o=s.findById(userid);
			System.out.println(o.getPwd());
			if(password==null||"".equals(password)){
				this.addFieldError("newpwd", "旧密码不能为空！请输入！");
			}else if(newpwd==null||"".equals(newpwd)){
				this.addFieldError("rnewpwd", "新密码密码不能为空！请输入！");
			}else if(rnewpwd==null||"".equals(rnewpwd)){
				this.addFieldError("newpwd", "确认密码密码不能为空！请输入！");
			}else if(!rnewpwd.equals(newpwd)){
				this.addFieldError("newpwd", "两次密码不一致请重新输入！");
			}else if(!password.equals(o.getPwd())){
				this.addFieldError("newpwd", "旧密码错误！");
			}
			else{
				
				o.setPwd(newpwd);
				s.update(o);
				this.addActionMessage("密码修改成功！");
				System.out.println("mail");
				r="pwd";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			r="fail";
		}
		finally{
		return r;
		}
	}
@SuppressWarnings("finally")
public String forget(){
	String r="input";
	
	try{
		System.out.println("00000000修改密码");
	
		
		System.out.println("修改密码");
		if(o.getUserid()==null||"".equals(o.getUserid())){
			this.addFieldError("o.userid", "账号不能为空！");
		}else if(u.getEmail()==null||"".equals(u.getEmail())){
			this.addFieldError("u.email", "邮箱不能为空！");
		}else if(newpwd==null||"".equals(newpwd)){
    		this.addFieldError("newpwd", "新密码不能为空！");
    	}else if(rnewpwd==null||"".equals(rnewpwd)){
    		this.addFieldError("rnewpwd", "确认密码不能为空！");
    	}
		else{
			String userid=o.getUserid();
			Logins o1=new Logins();
			o1=s.findById(userid);
			if(o1==null){
				this.addFieldError("o.userid", "不存在此账号！");
			}else{
				String uemail=u.getEmail();
				String regex = "(\\w{3,10}\\.)*\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		    	if(!uemail.matches(regex)){
		    		this.addFieldError("u.email", "您输入的邮箱格式不正确！");
		    	}else{
		    		u=us.findById(userid);
		    		if(!uemail.equals(u.getEmail())){
		    			this.addFieldError("u.email", "您输入的邮箱和账号不匹配！");
		    		}else{
		    			if(!newpwd.equals(rnewpwd)){
		    				this.addFieldError("newpwd", "两次密码不匹配！");
		    			}else{
		    				o=s.findById(o.getUserid());
		    				o.setPwd(newpwd);
		    				s.update(o);
		    				this.addActionMessage("密码成功找回！");
		    				r="forget";
		    			}
		    		}
		    	}
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		r="fail";
	}finally{
		return r;
	}
    
}
public void mima(){
//	Mail mail=new Mail();
//	mail.send();
	
}
	
}
