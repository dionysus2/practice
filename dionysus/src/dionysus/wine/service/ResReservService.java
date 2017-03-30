package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface ResReservService {
	
	/*
	 *  예약접수 전체 리스트 출력
	 *  레스토랑별 예약접수 리스트 출력
	 *  월별 예약접수 리스트 출력
	 *  일별 예약접수 리스트 출력
	 *  일반회원별 지난예약리스트 조회
	 *  레스토랑별 예약접수 판매량 조회
	 *  예약접수 추가
	 *  예약접수 정보수정
	 *  예약접수 정보삭제
	 */
	 public String readAllReserv(HttpServletRequest request)throws Exception;
	 public String readByResReserv(HttpServletRequest request)throws Exception;
	 public String readByMonthReserv(HttpServletRequest request)throws Exception;
	 public String readByDayReserv(HttpServletRequest request)throws Exception;
	 public String readByLastReserv(HttpServletRequest request)throws Exception;
	 public String readBySalesLate(HttpServletRequest request)throws Exception;
	 public String ResReservCreateStart(HttpServletRequest request)throws Exception;
	 public String ResReservCreateEnd(HttpServletRequest request)throws Exception;
	 public String ResReservUpdateStart(HttpServletRequest request)throws Exception;
	 public String ResReservUpdateEnd(HttpServletRequest request)throws Exception;
	 public String ResReservDelete(HttpServletRequest request) throws Exception;
	
}
