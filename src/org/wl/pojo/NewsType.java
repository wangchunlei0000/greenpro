package org.wl.pojo;

/**
 * NewsType entity. @author MyEclipse Persistence Tools
 */

public class NewsType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String style;
	private Boolean enable=true;

	// Constructors

	/** default constructor */
	public NewsType() {
	}

	/** minimal constructor */
	public NewsType(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public NewsType(Integer id, String style, Boolean enable) {
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
		return "NewsType [enable=" + enable + ", id=" + id + ", style=" + style
				+ "]";
	}

}