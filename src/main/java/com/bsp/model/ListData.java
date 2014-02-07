package com.bsp.model;

import java.util.List;

public class ListData<T> {

	private int total;
	
	private List<T> list;

	public ListData(int total, List<T> list) {
		this.total = total;
		this.list = list;
	}
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
