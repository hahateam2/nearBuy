package com.pojo;


public class Page {
//	默认为查询第一页
	private int page=1;
//	默认一页十条记录
	private int pageRows=10;

	private int totalRows;

	private int totalPages;

	private int startRow;

	private int endRow;
	
	
	public Page() {}
	public Page(int page) {
		super();
		this.page = page > 0 ? page : 0;
	}
	public Page(int page,int pageRows) {
		super();
		this.page = page > 0 ? page : 0;
		this.pageRows = pageRows > 0 ? pageRows : 10;
	}
	
	
	public int getpage() {
		return page;
	}
	public void setpage(int page) {
		this.page = page;
	}
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}

	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	
	public int getStartRow() {
		return this.pageRows*(this.page-1);
	}

	public int getEndRow() {
		return this.startRow+this.pageRows;
	}

	public int getTotalPages() {
		return this.totalRows/(this.pageRows+1)+1;
	}

}
