package org.wl.pojo;

import java.sql.Timestamp;

/**
 * RongziPoj entity. @author MyEclipse Persistence Tools
 */

public class RongziPoj implements java.io.Serializable {

	// Fields

	private Integer pojid;
	private RongziType rongziType;//以类的形式存在
	private Users users;
	private RongziState rongziState;
	private String name;
	private String introduce;
	private String icon;
	private Double money;
	private Double nowmoney;
	private String area;
	private String period;
	private Timestamp requesttime;
	private Timestamp starttime;
	private String by1;
	private String by2;
	private String by3;

	// Constructors

	/** default constructor */
	public RongziPoj() {
	}

	/** minimal constructor */
	public RongziPoj(RongziType rongziType, Users users, RongziState rongziState) {
		this.rongziType = rongziType;
		this.users = users;
		this.rongziState = rongziState;
	}

	/** full constructor */
	public RongziPoj(RongziType rongziType, Users users,
			RongziState rongziState, String name, String introduce,
			String icon, Double money, Double nowmoney, String area,
			String period, Timestamp requesttime, Timestamp starttime,
			String by1, String by2, String by3) {
		this.rongziType = rongziType;
		this.users = users;
		this.rongziState = rongziState;
		this.name = name;
		this.introduce = introduce;
		this.icon = icon;
		this.money = money;
		this.nowmoney = nowmoney;
		this.area = area;
		this.period = period;
		this.requesttime = requesttime;
		this.starttime = starttime;
		this.by1 = by1;
		this.by2 = by2;
		this.by3 = by3;
	}

	// Property accessors

	public void RongziPoj(RongziState state,RongziType style, Users userid) {
		// TODO Auto-generated constructor stub
		this.rongziState=state;
		this.rongziType=style;
		this.users=userid;
	}

	public Integer getPojid() {
		return this.pojid;
	}

	public void setPojid(Integer pojid) {
		this.pojid = pojid;
	}

	public RongziType getRongziType() {
		return this.rongziType;
	}

	public void setRongziType(RongziType rongziType) {
		this.rongziType = rongziType;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public RongziState getRongziState() {
		return this.rongziState;
	}

	public void setRongziState(RongziState rongziState) {
		this.rongziState = rongziState;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getNowmoney() {
		return this.nowmoney;
	}

	public void setNowmoney(Double nowmoney) {
		this.nowmoney = nowmoney;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Timestamp getRequesttime() {
		return this.requesttime;
	}

	public void setRequesttime(Timestamp requesttime) {
		this.requesttime = requesttime;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public String getBy1() {
		return this.by1;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}

	public String getBy2() {
		return this.by2;
	}

	public void setBy2(String by2) {
		this.by2 = by2;
	}

	public String getBy3() {
		return this.by3;
	}

	public void setBy3(String by3) {
		this.by3 = by3;
	}
	
}