package org.wl.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String userid="";
	private String name;
	private String sex;
	private String username;
	private String phone;
	private String email;
	private String fax;
	private String head;
	private Double money;
	private Set rongziPoj = new HashSet(0);
	// Constructors
	public Set getRongziPoj() {
		return rongziPoj;
	}

	public void setRongziPoj(Set rongziPoj) {
		this.rongziPoj = rongziPoj;
	}
	// Constructors

	/** default constructor */
	public Users() {
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Double getMoney() {
		
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Users [email=" + email + ", fax=" + fax + ", head=" + head
				+ ", money=" + money + ", name=" + name + ", phone=" + phone
				+ ", rongziPoj=" + rongziPoj + ", sex=" + sex + ", userid="
				+ userid + ", username=" + username + "]";
	}

	

	

}