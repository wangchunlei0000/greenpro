package org.wl.pojo;

import java.sql.Timestamp;


/**
 * NewsPoj entity. @author MyEclipse Persistence Tools
 */

public class NewsPoj implements java.io.Serializable {

	// Fields

	private Integer id;
	private NewsType newsType;
	private Users users;
	private String text;
	private String head;
	private String icon;
	private Integer count;
	private Timestamp starttime;
	private String state;
	private String by2;

	// Constructors

	/** default constructor */
	public NewsPoj() {
	}

	/** minimal constructor */
	public NewsPoj(Users users) {
		this.users = users;
	}

	/** full constructor */
	public NewsPoj(NewsType newsType, Users users, String text, String head,
			String icon, Integer count, Timestamp starttime, String state,
			String by2) {
		this.newsType = newsType;
		this.users = users;
		this.text = text;
		this.head = head;
		this.icon = icon;
		this.count = count;
		this.starttime = starttime;
		this.state = state;
		this.by2 = by2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NewsType getNewsType() {
		return this.newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBy2() {
		return this.by2;
	}

	public void setBy2(String by2) {
		this.by2 = by2;
	}

}