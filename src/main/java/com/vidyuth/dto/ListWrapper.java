package com.vidyuth.dto;

import java.util.ArrayList;
import java.util.List;

public class ListWrapper<T> {
	private Class<T> clazz;
	private List<T> list;
	
	public ListWrapper(Class<T> clazz) {
		this.clazz = clazz;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public void add(T t){
		if(list==null)
			list = new ArrayList<T>();
		list.add(t);
	}
	
	

}
