package com.hwhongdb.file.service;

import java.util.List;

import com.hwhongdb.file.common.Page;
import com.hwhongdb.file.domain.Music;

public interface FileInputService {

	/**
	 * 添加歌曲
	 * @param music 歌曲
	 */
	void addMusic(Music music);

	/**
	 * 获取歌曲
	 * @return 返回集合
	 */
	List<Music> findAllMusic();

	/**
	 * 根据num获取一个分页
	 * @param num
	 * @return
	 */
	Page findAllPageMusic(String num);

	/**
	 * 根据id获取歌曲
	 * @param id
	 * @return
	 */
	Music findByMusic(String id);

	/**
	 * 修改歌曲
	 * @param music
	 */
	void updateMusic(Music music);

	/**
	 * 删除歌曲
	 * @param id
	 */
	void delectMusic(String id);


}
