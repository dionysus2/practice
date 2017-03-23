package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface BasicInfoService {
	/*
	 * 	1. 추가
	 * 	2. 삭제
	 * 	3. 비밀번호, 이메일 수정
	 * 	4. 로그인
	 * 	5. 아이디 중복확인
	 * */
	public String createEnd(HttpServletRequest request);
	public String updateStart(HttpServletRequest request);
	public String updateEnd(HttpServletRequest request);
	public String login(HttpServletRequest request);
	public String readUsernameCheck(HttpServletRequest request);
}
