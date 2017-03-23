package dionysus.wine.dao;

import java.sql.Connection;

public interface ResReservInfoDAO {
	/*
	 * 레스토랑 예약상세(레스토랑번호,레스토랑 예약번호, 신청예약 좌석수)
	 * 															리턴				매개변수
	 * 1. 예약추가												int			Connection, 레스토랑번호, 레스토랑 예약번호, 신청좌석수
	 * 2. 예약삭제												int			Connection, 레스토랑 예약번호, 레스토랑번호
	 * 3. 예약 좌석수 수정										int 		Connection, 레스토랑번호, 레스토랑 예약번호, 변경좌석수
	 * 
	 * */

	 public int insertResReservInfo(Connection conn, int resInfoId, int resReservId, int resResrvInfoBookingSeats)throws Exception;
	 public int deleteResReservInfo(Connection conn, int resReservId, int resInfoId)throws Exception;
	 public int updateResReservInfo(Connection conn, int resInfoId, int resReservId, int resResrvInfoBookingSeats)throws Exception;
}

