package com.hwhongdb.file.domain;

import java.io.Serializable;

public class Music implements Serializable {

	/**
	 * id : uuid title : ¸èÇúÃû singer : ¸èÊÖ song : ¸èÇúÃû³Æ picture : Í¼Æ¬Ãû³Æ lyrics : ¸è´ÊÃû³Æ
	 * 
	 */

	private int id;
	private String title;
	private String singer;
	private String song;
	private String songPath;
	private String picture;
	private String picturePath;
	private String lyrics;
	private String lyricsPath;

	public Music() {

	}

	public Music(String title, String singer, String song, String picture, String lyrics) {
		this.title = title;
		this.singer = singer;
		this.song = song;
		this.picture = picture;
		this.lyrics = lyrics;
	}

	public Music(int id, String title, String singer, String song, String picture, String lyrics) {
		this.id = id;
		this.title = title;
		this.singer = singer;
		this.song = song;
		this.picture = picture;
		this.lyrics = lyrics;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public String getSongPath() {
		return songPath;
	}

	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getLyricsPath() {
		return lyricsPath;
	}

	public void setLyricsPath(String lyricsPath) {
		this.lyricsPath = lyricsPath;
	}

	@Override
	public String toString() {
		return "Music [id=" + id + ", title=" + title + ", singer=" + singer + ", song=" + song + ", songPath="
				+ songPath + ", picture=" + picture + ", picturePath=" + picturePath + ", lyrics=" + lyrics
				+ ", lyricsPath=" + lyricsPath + "]";
	}

	
}
