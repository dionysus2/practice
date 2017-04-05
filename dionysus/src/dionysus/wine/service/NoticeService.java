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
	public String readNotice(HttpServletRequest request);
	public String createNotice(HttpServletRequest request);
	public String updateNoticeStart(HttpServletRequest reuqest);
	public String updateNoticeEnd(HttpServletRequest request);
	public String deleteNotice(HttpServletRequest request);
	public String readByNoticeId(HttpServletRequest request);
	
	//	공지사항 게시글 전체보기
	//	공지사항 게시글 카운트
	
	//	공지사항 게시글 추가하기.
	//	공지사항 게시글 수정하기.
	//	공지사항 게시글 삭제하기.

	//	공지사항 NOTICE_VIEWS MAX+1값 조회
	//	공지사랑 NOTICE_VIEWS MAX+1값 조회후 UPDATE문
	//	공지사항 게시글 번호별 조회하기
}