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
	
}
