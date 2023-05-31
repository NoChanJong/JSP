package com.lec.simple;

import java.util.Date;

public class Board {

	private int bno;
	private String subject;
	private String writer;
	private String content;
	private int readcnt;
	private Date crtdate;
	
	public Board(int bno, String subject, String writer, String content, int readcnt, Date crtdate) {
		super();
		this.bno = bno;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.readcnt = readcnt;
		this.crtdate = crtdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public Date getCrtdate() {
		return crtdate;
	}

	public void setCrtdate(Date crtdate) {
		this.crtdate = crtdate;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", subject=" + subject + ", writer=" + writer + "]";
	}
}
