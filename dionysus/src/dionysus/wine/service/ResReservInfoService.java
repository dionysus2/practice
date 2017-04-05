package dionysus.wine.service;

import javax.servlet.http.HttpServletRequest;

public interface ResReservInfoService {
	/*
	  															
	 * 1. 예약추가											
	 * 2. 예약삭제												
	 * 3. 예약 좌석수 수정									
	 
	 * */
     public String CreateResReservInfo(HttpServletRequest request);
     public String UpdateResReservInfo(HttpServletRequest request);
     public String deleteResReservInfo(HttpServletRequest request);
}
