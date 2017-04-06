package dionysus.wine.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class Notice {
	
	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWriter;
	private Date noticeWritedate;
	private int noticeViews;
	public Notice(String noticeTitle, String noticeContent, String noticeWriter) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
	}
	public Notice() {
		// TODO Auto-generated constructor stub
	}
}
