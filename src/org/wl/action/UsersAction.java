package org.wl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.wl.pojo.Page;
import org.wl.pojo.Users;
import org.wl.pojo.UsersEmail;
import org.wl.service.UsersEmailService;
import org.wl.service.UsersService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport {
	private Users o = new Users();
	private UsersEmail e=new UsersEmail();
	private UsersEmailService es=new UsersEmailService();
	UsersService s=new UsersService();
	private List<Users> l;
	private Page p=new Page();
	private File mypic;
	private String mypicFileName;
	
	public String getMypicFileName() {
		return mypicFileName;
	}
	public void setMypicFileName(String mypicFileName) {
		this.mypicFileName = mypicFileName;
	}
	public File getMypic() {
		return mypic;
	}
	public void setMypic(File mypic) {
		this.mypic = mypic;
	}
	public Page getP() {
		return p;
	}
	public void setP(Page p) {
		this.p = p;
	}
	public List<Users> getL() {
		return l;
	}
	public void setL(List<Users> l) {
		this.l = l;
	}
	
	public Users getO() {
		return o;
	}
	public void setO(Users o) {
		this.o = o;
	}
	
	public void validateUpdate(){
	System.out.println("users Action  数据校验");
	System.out.println("email:"+o.getEmail());
	System.out.println("phone:"+o.getPhone());
    if (o.getEmail()!=null&!"".equals(o.getEmail())){//邮箱验证
    	System.out.println("email jiaoyan");
    	String regex = "(\\w{3,10}\\.)*\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
    	String email=o.getEmail();
    	if(!email.matches(regex)){
    		System.out.println("bu pi pei");
    		this.addFieldError("o.email", "您输入的邮箱地址不正确！");
    	}
    }if (o.getPhone()!=null&!"".equals(o.getPhone())){//电话号
    	System.out.println("phone jiaoyan");
    	String phone=o.getPhone();
    	String regex= "^(1)\\d{10}$";
    	if(!phone.matches(regex)){
    		System.out.println("bu pipei dianhua ");
    		this.addFieldError("o.phone", "您输入的电话号码不正确！");
    	}
    }if(o.getMoney()!=null&!"".equals(o.getMoney())){
    	
		String money=o.getMoney().toString();
		System.out.println(money);
		DecimalFormat df=new DecimalFormat("#0.00");
		Double d=Double.parseDouble(money);  
		BigDecimal big = new BigDecimal(df.format(d));
		money=big.toString();
		System.out.println(money);
		String regex="^\\d{1,}\\.{0,1}\\d{0,2}$";
		if(!money.matches(regex)){
			this.addFieldError("o.money", "您输入的金额不正确！");
			o.setMoney(0.0);
		}
		o.setMoney(Double.parseDouble(money));
	}
    
	}
	@SuppressWarnings("finally")
	public String update(){
        String r=this.INPUT;
		try{
			Users o1 = new Users();
			System.out.println(o.getUserid().toString());
    		o1=s.findById(o.getUserid().toString());//当前用户
    		System.out.println(o.getUserid().toString());
			if(mypic==null){//没有选图片
				if(o1.getHead()==null||"".equals(o1.getHead())){
					s.update(o);
					
					r= "update";
				}
				o.setHead(o1.getHead());
				s.update(o);
				r="update";
			}else{
			String saveName="img/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(this.mypicFileName);
			String savePath=ServletActionContext.getServletContext().getRealPath(saveName);
			FileInputStream input=new FileInputStream(mypic);
			FileOutputStream output=new FileOutputStream(savePath);
			o.setHead(saveName);
			s.update(o);
			IOUtils.copy(input, output);
			output.flush();
			input.close();
			output.close();
			r="update";
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			return r;
		}
}
	public String look(){
		try{
		System.out.println("look"+o.getUserid());
		o=s.findById(o.getUserid());
		return "look";}
		catch(Exception e){
			return this.INPUT;
		}
	}
public String toup(){
		try{
		System.out.println(o.getUserid().toString());
		o=s.findById(o.getUserid().toString());
		return "toup";}
		catch(Exception e){
			return this.INPUT;
		}
	}

public String findAll(){
	String role=(String)ActionContext.getContext().getSession().get("role");//获取登陆的角色
	p.setRowCount(s.getRowByTitle(role,o.getUserid()));
	l=s.findAllByTitle(p.getCurrentPage(),p.getPageSize(),role,o.getUserid());
	ActionContext.getContext().getSession().put("users", o.getUserid());
	ActionContext.getContext().getSession().put("li", l);
	System.out.println(l.toString());
	return "findAll";
	
}
public String test(){
	String role=(String) ActionContext.getContext().getSession().get("role");
	String users=(String) ActionContext.getContext().getSession().get("users");
	List<Users> li=(List<Users>) ActionContext.getContext().getSession().get("li");
	p.setRowCount(s.getRowByTitle(role,users));
	li=s.findAllByTitle(p.getCurrentPage(),p.getPageSize(),role,users);
	l=li;
	System.out.println(l.toString());
	return "test";
}

	
}