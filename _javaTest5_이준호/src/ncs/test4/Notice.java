package ncs.test4;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;

	private int no;
	private String title;
	private Date date;
	private String writer;
	private String content;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int no, String title, Date date, String writer, String content) {
		super();
		this.no = no;
		this.title = title;
		this.date = date;
		this.writer = writer;
		this.content = content;
	}

	@Override
	public String toString() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		return "Notice no." + no + "\t" + formatter.format(date) + "\t" 
				+ writer + "\t" + content +".";
	}
	
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; } 
}
