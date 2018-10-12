package com.hwhongdb.file.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hwhongdb.file.dao.FileInputDao;
import com.hwhongdb.file.domain.Music;
import com.hwhongdb.file.exception.DaoException;
import com.hwhongdb.file.util.DBCPUtil;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.scenario.effect.Offset;

public class FileInputDaoImpl implements FileInputDao {

	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	
	@Override
	public void add(Music music) {
		if (music.getPicture() == null || "".equals(music.getPicture())) {
			music.setPicture("00.jpg");
			music.setPicturePath("/0/0");
		}
		if (music.getLyrics() == null || "".equals(music.getLyricsPath())) {
			music.setLyrics("00.lrc");
			music.setLyricsPath("/0/0");
		}
		try {
			qr.update("INSERT INTO music_file(title,singer,song,songPath,picture,picturePath,lyrics,lyricsPath) "
					+ "VALUES (?,?,?,?,?,?,?,?)",
					music.getTitle(),
					music.getSinger(),
					music.getSong(),
					music.getSongPath(),
					music.getPicture(),
					music.getPicturePath(),
					music.getLyrics(),
					music.getLyricsPath());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void deleteById(String id) {
		try {
			qr.update("DELETE FROM music_file WHERE id = ?" , id);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(Music music) {
		
		Music m = findById(music.getId()+"");
		
		if (music.getSong() == null || "".equals(music.getSong())) {
			music.setSong(m.getSong());
		}
		if (music.getSongPath() == null || "".equals(music.getSongPath())) {
			music.setSongPath(m.getSongPath());
		}
		if (music.getPicture() == null || "".equals(music.getPicture())) {
			music.setPicture(m.getPicture());
		}
		if (music.getPicturePath() == null || "".equals(music.getPicturePath())) {
			music.setPicturePath(m.getPicturePath());
		}
		if (music.getLyrics() == null || "".equals(music.getLyrics())) {
			music.setLyrics(m.getLyrics());
		}
		if (music.getLyricsPath() == null || "".equals(music.getLyricsPath())) {
			music.setLyricsPath(m.getLyricsPath());
		}
		
		
		try {
			qr.update("UPDATE music_file SET title=?,singer=?,song=?,songPath=?,picture=?,picturePath=?,lyrics=?,lyricsPath=?"
					+ "where id=?",
					music.getTitle(),
					music.getSinger(),
					music.getSong(),
					music.getSongPath(),
					music.getPicture(),
					music.getPicturePath(),
					music.getLyrics(),
					music.getLyricsPath(),
					music.getId());
		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public Music findById(String musicId) {
		try {
			return qr.query("SELECT * FROM music_file where id = ?", new BeanHandler<Music>(Music.class) ,musicId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Music> findAll() {
		
		try {
			return qr.query("SELECT * FROM music_file", new BeanListHandler<Music>(Music.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public int findAllNumber() {
		try {
			Object obj = qr.query("SELECT COUNT(*) FROM music_file", new ScalarHandler(1));
			Long num = (Long)obj;
			return num.intValue();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Music> findPageMusics(int startIndex, int pageSize) {
		try {
			return qr.query("SELECT * FROM music_file LIMIT ?,?", new BeanListHandler<Music>(Music.class),startIndex,pageSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}



}
