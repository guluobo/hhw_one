package com.hwhongdb.file.service.impl;

import java.util.List;
import java.util.UUID;

import com.hwhongdb.file.common.Page;
import com.hwhongdb.file.dao.FileInputDao;
import com.hwhongdb.file.dao.impl.FileInputDaoImpl;
import com.hwhongdb.file.domain.Music;
import com.hwhongdb.file.service.FileInputService;

public class FileInputServiceImpl implements FileInputService {

	FileInputDao dao = new FileInputDaoImpl();
	
	@Override
	public void addMusic(Music music) {
		dao.add(music);
	}

	@Override
	public List<Music> findAllMusic() {
		return dao.findAll();
	}

	@Override
	public Page findAllPageMusic(String num) {
		int currentPageNum = 1;
		
		if (num != null) {
			currentPageNum = Integer.parseInt(num);
		}
		
		int totalRecords = dao.findAllNumber();
		Page page = new Page(currentPageNum,totalRecords);
		
		page.setRecords(dao.findPageMusics(page.getStartIndex(),page.getPageSize()));
		
		return page;
		
	}

	@Override
	public Music findByMusic(String id) {
		return dao.findById(id);
	}

	@Override
	public void updateMusic(Music music) {
		dao.update(music);
	}

	@Override
	public void delectMusic(String id) {
		dao.deleteById(id);
	}

}
