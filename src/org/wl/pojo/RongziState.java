package org.wl.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * NewsType entity. @author MyEclipse Persistence Tools
 */

public class RongziState implements java.io.Serializable {

	// Fields

	private Integer id;
	private String style;
	private Boolean enable=true;
	private Set rongziPoj = new HashSet(0);
	// Constructors
	
	/** default constructor */
	public RongziState() {
	}

	public Set getRongziPoj() {
		return rongziPoj;
	}

	public void setRongziPoj(Set rongziPoj) {
		this.rongziPoj = rongziPoj;
	}

	/** minimal constructor */
	public RongziState(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public RongziState(Integer id, String style, Boolean enable) {
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
		return "RongziState [enable=" + enable + ", id=" + id + ", style=" + style
				+ "]";
	}

}