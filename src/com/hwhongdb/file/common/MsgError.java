package com.hwhongdb.file.common;

public class MsgError {
	
	private String title;
	private String singer;
	private String song;
	private String picture;
	private String lyrics;
		
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
	@Override
	public String toString() {
		return "MsgError [title=" + title + ", singer=" + singer + ", song=" + song + ", picture=" + picture
				+ ", lyrics=" + lyrics + "]";
	}
	
	
}
