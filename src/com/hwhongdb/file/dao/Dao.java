package com.hwhongdb.file.dao;

import java.util.List;

import com.hwhongdb.file.domain.Music;

public interface Dao<T> {

	void add(T bean);
	
	void deleteById(String id);
	
	T findById(String id);

	void update(T bean);
	
	List<T> findAll();
	
	
}
