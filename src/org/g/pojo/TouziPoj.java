package org.g.pojo;

import java.sql.Timestamp;

import org.wl.pojo.Users;

/**
 * RongziPoj entity. @author MyEclipse Persistence Tools
 */

public class TouziPoj implements java.io.Serializable {

	// Fields

	private Integer pojid;
	private TouziType touziType;//�������ʽ����
	private Users users;
	private TouziState touziState;
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
	private Integer by2;
	private String by3;

	// Constructors

	/** default constructor */
	public TouziPoj() {
	}

	/** minimal constructor */
	public TouziPoj(TouziType touziType, Users users, TouziState touziState) {
		this.touziType = touziType;
		this.users = users;
		this.touziState = touziState;
	}

	/** full constructor */
	public TouziPoj(TouziType touziType, Users users,
			TouziState touziState, String name, String introduce,
			String icon, Double money, Double nowmoney, String area,
			String period, Timestamp requesttime, Timestamp starttime,
			String by1, Integer by2, String by3) {
		this.touziType = touziType;
		this.users = users;
		this.touziState = touziState;
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

	public void TouziPoj(TouziState state,TouziType style, Users userid) {
		// TODO Auto-generated constructor stub
		this.touziState=state;
		this.touziType=style;
		this.users=userid;
	}

	public Integer getPojid() {
		return this.pojid;
	}

	public void setPojid(Integer pojid) {
		this.pojid = pojid;
	}

	public TouziType getTouziType() {
		return this.touziType;
	}

	public void setTouziType(TouziType touziType) {
		this.touziType = touziType;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public TouziState getTouziState() {
		return this.touziState;
	}

	public void setTouziState(TouziState touziState) {
		this.touziState = touziState;
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

	

	public Integer getBy2() {
		return by2;
	}

	public void setBy2(Integer by2) {
		this.by2 = by2;
	}

	public String getBy3() {
		return this.by3;
	}

	public void setBy3(String by3) {
		this.by3 = by3;
	}
	
}