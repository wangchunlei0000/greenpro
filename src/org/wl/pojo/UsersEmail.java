package org.wl.pojo;

import java.sql.Timestamp;

/**
 * UsersEmail entity. @author MyEclipse Persistence Tools
 */

public class UsersEmail implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String text;
	private Integer n;
	private Timestamp by1;
	private String head;
	// Constructors

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	/** default constructor */
	public UsersEmail() {
	}

	/** full constructor */

	public void UsersEmail(String email, String text, Integer n){
			this.email=email;
			this.text=text;
			this.n=n;
	}
	
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getN() {
		return this.n;
	}

	public void setN(Integer n) {
		this.n = n;
	}


	public Timestamp getBy1() {
		return by1;
	}

	public void setBy1(Timestamp by1) {
		this.by1 = by1;
	}

	@Override
	public String toString() {
		return "UsersEmail [by1=" + by1 + ", email=" + email + ", id=" + id
				+ ", n=" + n + ", text=" + text + "]";
	}


	

}