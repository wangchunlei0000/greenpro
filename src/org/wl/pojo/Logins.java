package org.wl.pojo;

import java.sql.Timestamp;

/**
 * Logins entity. @author MyEclipse Persistence Tools
 */

public class Logins implements java.io.Serializable {

	// Fields

	private String userid;
	private String pwd;
	private String role;
	private String enable;
	private Timestamp regtime;
	private String beiyong1;

	// Constructors

	/** default constructor */
	public Logins() {
	}

	/** minimal constructor */
	public Logins(String userid, String pwd, String role, String enable) {
		this.userid = userid;
		this.pwd = pwd;
		this.role = role;
		this.enable = enable;
	}

	/** full constructor */
	public Logins(String userid, String pwd, String role, String enable,
			Timestamp regtime, String beiyong1) {
		this.userid = userid;
		this.pwd = pwd;
		this.role = role;
		this.enable = enable;
		this.regtime = regtime;
		this.beiyong1 = beiyong1;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Timestamp getRegtime() {
		return this.regtime;
	}

	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}

	public String getBeiyong1() {
		return this.beiyong1;
	}

	public void setBeiyong1(String beiyong1) {
		this.beiyong1 = beiyong1;
	}

}