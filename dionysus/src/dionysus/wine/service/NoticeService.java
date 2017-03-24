package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface NoticeService {
	/*
	 * 	- 공지사항 게시판 페이지별 조회.				
	 * 		1. 공지사항 게시판 페이지별 조회.					
	 * 	- 공지사항 게시판 게시글 작성.
	 * 		3. 공지사항 게시글 작성					
	 * 	- 공지사항 게시판 게시글 수정.
	 * 		4. 공지사항 게시글 수정.				
	 * 	- 공지사항 게시판 게시글 삭제.
	 * 		5. 공지사항 게시글 삭제					
	 * 	6. 공지사항 게시글 조회수 증가					
	 * */
	public String readNotice(HttpServletRequest req);
	public String createNotice(HttpServletRequest req);
	public String updateNotice(HttpServletRequest req);
	public String deleteNotice(HttpServletRequest req);
	public String viewsNotice(HttpServletRequest req);
}
