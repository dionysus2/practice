package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface NoticeCommentService {
	/*
	 게시글별 댓글 리스트 조회				
	 *		1. 게시글별 댓글 리스트 조회		
	 *	- 게시글별 댓글 작성
	 *		2. 게시글별 댓글 작성										
	 *	- 게시글별 댓글 수정					
	 *		3. 게시글별 작성 댓글 수정			
	 *	- 게시글별 댓글 삭제
	 *		4. 게시글별 작성 댓글 삭제
	 **/
	public String readNoticeComment(HttpServletRequest req);
	public String createNoticeComment(HttpServletRequest req);
	public String updateNoticeComment(HttpServletRequest req);
	public String deleteNoticeComment(HttpServletRequest req);
	
}
