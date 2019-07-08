package com.jdbc.model.vo;

import java.sql.Date;

public class Board {
    private int idx;
    private String div; //'공지' '일반' '비밀'
    private String title;
    private String boardComment;
    private String writer;
    private Date writeDate;

    public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int idx, String div, String title, String boardComment, String writer, Date writeDate) {
		super();
		this.idx = idx;
		this.div = div;
		this.title = title;
		this.boardComment = boardComment;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", div=" + div + ", title=" + title + ", boardComment=" + boardComment
				+ ", writer=" + writer + ", writeDate=" + writeDate + "]";
	}

	public int getIdx() { return idx; } 
	public void setIdx(int idx) { this.idx = idx; } 
	public String getDiv() { return div; } 
	public void setDiv(String div) { this.div = div; } 
	public String getTitle() { return title; } 
	public void setTitle(String title) { this.title = title; } 
	public String getBoardComment() { return boardComment; } 
	public void setBoardComment(String boardComment) { this.boardComment = boardComment; } 
	public String getWriter() { return writer; } 
	public void setWriter(String writer) { this.writer = writer; } 
	public Date getWriteDate() { return writeDate; } 
	public void setWriteDate(Date writeDate) { this.writeDate = writeDate; } 
}
