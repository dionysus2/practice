package dionysus.wine.vo;

import lombok.Data;

@Data
public class NoticeComment {
	
	private int customerId;
	private int noticeId;
	private String noticeCommentContent;

}
