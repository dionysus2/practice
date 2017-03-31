package dionysus.wine.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dionysus.wine.vo.Res;
import dionysus.wine.vo.ResInfo;
import dionysus.wine.vo.ResReserv;
import dionysus.wine.vo.WineOrder;

public interface ResReservDAO {
	/*
	 * 레스토랑 예약(레스토랑 예약번호,예약일자,예약금액,고객번호)
	 * 												리턴						매개변수
<<<<<<< HEAD
	 * 1.예약접수 전체 리스트 출력					ArrayList<ResReserv>	Connection  startRow,lastRow
	 * 2.레스토랑별 예약접수 리스트 출력			ArrayList<ResReserv>			Connection, 레스토랑번호
=======
	 * 1.예약접수 전체 리스트 출력					ArrayList<ResReserv>	Connection, startRow, lastRow
	 * 2.레스토랑별 예약접수 리스트 출력			ArrayList<ResReserv>	Connection, 레스토랑번호
	 * 2. 레스토랑 예약 count조회						int						Connection	
     * 3.월별 예약접수 리스트 출력					ArrayList<ResReserv>	Connection, date							
	 * 4.일별 예약접수 리스트 출력					ArrayList<ResReserv>	Conneciton, date
	 * 5.일반회원별 지난예약리스트 조회			ArrayList<ResReserv>	Connection, 회원번호
	 * 6.레스토랑별 예약접수 판매량 조회			ArrayList<WineOrder>	Connection, 와인판매량
	 * 7.예약접수 추가									int					Connection, 레스토랑번호,회원번호,예약일자,예약금액
	 * 8.예약접수 정보수정								int					Connection, 예약일자,예약금액
	 * 9.예약접수 정보삭제								int					Connection, 예약번호
	 *  8.예약번호별 예약정보 조회                   ResReserv               	Connection, 레스토랑 회원번호
	 */

	public ArrayList<ResReserv>selectAllReserv(Connection conn, int startRow, int lastRow)throws Exception;
	public int selectByReservCount(Connection conn)throws Exception;
	public ArrayList<ResReserv>selectByResReserv(Connection conn, int resInfoId)throws Exception;
	public ArrayList<ResReserv>selectByMonthReserv(Connection conn, Date resResrvDate)throws Exception;
	public ArrayList<ResReserv>selectByDayReserv(Connection conn, Date resResrvDate)throws Exception;
	public ArrayList<ResReserv>selectByLastReserv(Connection conn, int customerId)throws Exception;
	public int selectBySalesLate(Connection conn, int resInfoId)throws Exception;
	public int insertReserv(Connection conn,Date resResrvDate, int resResrvFee,int resId, int customerId)throws Exception;
	public int updateReserv(Connection conn, Date resResrvDate,int resResrvFee)throws Exception;
	public int deleteReserv(Connection conn, int resResrvId)throws Exception;
	public ResReserv selectResReserv(Connection conn, int resResrvId)throws Exception;
}
