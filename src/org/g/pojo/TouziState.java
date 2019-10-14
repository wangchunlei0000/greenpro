package org.g.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * NewsType entity. @author MyEclipse Persistence Tools
 */

public class TouziState implements java.io.Serializable {

	// Fields

	private Integer id;
	private String style;
	private Boolean enable=true;
	private Set touziPoj = new HashSet(0);
	// Constructors
	
	/** default constructor */
	public TouziState() {
	}

	public Set getTouziPoj() {
		return touziPoj;
	}

	public void setTouziPoj(Set touziPoj) {
		this.touziPoj = touziPoj;
	}

	/** minimal constructor */
	public TouziState(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TouziState(Integer id, String style, Boolean enable) {
		this.id = id;
		this.style = style;
		this.enable = enable;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "TouziState [enable=" + enable + ", id=" + id + ", style=" + style
				+ "]";
	}

}