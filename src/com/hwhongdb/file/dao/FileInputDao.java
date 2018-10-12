package com.hwhongdb.file.dao;

import java.util.List;

import com.hwhongdb.file.domain.Music;

public interface FileInputDao extends Dao<Music> {

	int findAllNumber();

	List<Music> findPageMusics(int startIndex, int pageSize);
}
