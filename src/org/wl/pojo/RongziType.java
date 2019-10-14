package org.wl.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * NewsType entity. @author MyEclipse Persistence Tools
 */

public class RongziType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String style;
	private Boolean enable=true;
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
	public RongziType() {
	}

	/** minimal constructor */
	public RongziType(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public RongziType(Integer id, String style, Boolean enable) {
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
		return "RongziType [enable=" + enable + ", id=" + id + ", style=" + style
				+ "]";
	}

}