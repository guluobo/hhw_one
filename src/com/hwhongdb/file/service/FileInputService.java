package com.hwhongdb.file.service;

import java.util.List;

import com.hwhongdb.file.common.Page;
import com.hwhongdb.file.domain.Music;

public interface FileInputService {

	/**
	 * ��Ӹ���
	 * @param music ����
	 */
	void addMusic(Music music);

	/**
	 * ��ȡ����
	 * @return ���ؼ���
	 */
	List<Music> findAllMusic();

	/**
	 * ����num��ȡһ����ҳ
	 * @param num
	 * @return
	 */
	Page findAllPageMusic(String num);

	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	Music findByMusic(String id);

	/**
	 * �޸ĸ���
	 * @param music
	 */
	void updateMusic(Music music);

	/**
	 * ɾ������
	 * @param id
	 */
	void delectMusic(String id);


}
