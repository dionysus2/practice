package dionysus.wine.dao;

public interface ResReservDAO {
	/*
	 * 레스토랑 예약(레스토랑 예약번호,예약일자,예약금액,고객번호)
	 * 												리턴						매개변수
	 * 1.예약접수 전체 리스트 출력							ArrayList<ResInfo>		Connection
	 * 2.레스토랑별 예약접수 리스트 출력						ArrayList<Res>			Connection, 레스토랑
	 * 3.월별 예약접수 리스트 출력							ArrayList<ResReserv>	Connection, date							
	 * 4.일별 예약접수 리스트 출력							ArrayList<ResReserv>	Conneciton, date
	 * 5.일반회원별 지난예약리스트 조회						ArrayList<ResReserv>
	 * 6.레스토랑별 예약접수 판매량 조회						ArrayList<WineOrder>	Connection, 와인판매량
	 * 7.예약접수 추가									int					Connection, 레스토랑번호,회원번호,예약일자,예약금액
	 * 8.예약접수 정보수정								int					Connection, 예약일자,예약금액
	 * 9.예약접수 정보삭제								int					Connection, 예약번호
	 * 
	 */
}
