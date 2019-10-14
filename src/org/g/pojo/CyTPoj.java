package org.g.pojo;

import java.sql.Timestamp;

import org.wl.pojo.Users;

/**
 * CyTPoj entity. @author MyEclipse Persistence Tools
 */

public class CyTPoj implements java.io.Serializable {

	// Fields

	private Integer id;
	private TouziPoj touzipoj;
	private Users users;
	private Double money;
	private Timestamp by1;
	private Integer count;
	
	// Constructors

	public TouziPoj getTouzipoj() {
		return touzipoj;
	}

	public void setTouzipoj(TouziPoj touzipoj) {
		this.touzipoj = touzipoj;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	/** default constructor */
	public CyTPoj() {
	}

	/** minimal constructor */
	public CyTPoj(TouziPoj touziPoj, Users users) {
		this.touzipoj = touziPoj;
		this.users = users;
	}

	/** full constructor */
	public CyTPoj(TouziPoj touziPoj, Users users, Double money, Timestamp by1) {
		this.touzipoj = touziPoj;
		this.users = users;
		this.money = money;
		this.by1 = by1;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TouziPoj getTouziPoj() {
		return this.touzipoj;
	}

	public void setTouziPoj(TouziPoj touziPoj) {
		this.touzipoj = touziPoj;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Timestamp getBy1() {
		return this.by1;
	}

	public void setBy1(Timestamp by1) {
		this.by1 = by1;
	}

	public void CyTPoj(TouziPoj touziPoj, Users users, double money) {
		this.touzipoj = touziPoj;
		this.users = users;
		this.money = money;
		
		
	}

	
}