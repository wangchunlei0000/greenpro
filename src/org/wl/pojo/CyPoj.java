package org.wl.pojo;

/**
 * CyPoj entity. @author MyEclipse Persistence Tools
 */

public class CyPoj implements java.io.Serializable {

	// Fields

	private Integer id;
	private RongziPoj rongziPoj;
	private Users users;
	private Double money;
	private String by1;

	// Constructors

	/** default constructor */
	public CyPoj() {
	}

	/** minimal constructor */
	public CyPoj(RongziPoj rongziPoj, Users users) {
		this.rongziPoj = rongziPoj;
		this.users = users;
	}

	/** full constructor */
	public CyPoj(RongziPoj rongziPoj, Users users, Double money, String by1) {
		this.rongziPoj = rongziPoj;
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

	public RongziPoj getRongziPoj() {
		return this.rongziPoj;
	}

	public void setRongziPoj(RongziPoj rongziPoj) {
		this.rongziPoj = rongziPoj;
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

	public String getBy1() {
		return this.by1;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}

	public void CyPoj(RongziPoj rongziPoj, Users users, double money) {
		this.rongziPoj = rongziPoj;
		this.users = users;
		this.money = money;
		
		
	}

	
}