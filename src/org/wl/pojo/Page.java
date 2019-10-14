package org.wl.pojo;

public class Page {

	private int currentPage=1;//当前页面
	private int pageSize=5;//每页记录数
	private int rowCount=0;//总的符合条件的纪录数目
	private int pageCount=0;//总页数
	public void setRowCount(int rowCount){
		this.rowCount = rowCount;
		this.pageCount=(int)Math.ceil((double)this.rowCount/(double)this.pageSize);
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageCount=" + pageCount
				+ ", pageSize=" + pageSize + ", rowCount=" + rowCount + "]";
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	
	
}
