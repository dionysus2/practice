package dionysus.wine.query;

public interface ResResrvQuery {
    //      예약접수 전체 리스트 출력
	public String selectAllReserv = "select T2.* from(select rownum rnum, T1.* from(select * from res_Reserv)T1)T2 where rnum between ? and ?";
    //      레스토랑별 예약접수 리스트 출력
	public String selectByResReserv = "select T2.* from(select rownum rnum, T1.* from(select * from res_Reserv where res_Id=?)T1)T2 where rnum between ? and ?";
    //      월별 범위안 예약접수 리스트 출력
    public String selectByMonthReserv = "select T2.* from(select rownum rnum, T1.* from(select * from res_Reserv where res_Reserv_Date between '????/??/??' and '????/??/??')T1)T2 where rnum between ? and ?";
    //      일별 범위안 예약접수 리스트 출력
    public String selectByDayReserv = "select T2.* from(select rownum rnum, T1.* from(select * from res_Reserv where res_Reserv_Date between '????/??/??' and '????/??/??')T1)T2 where rnum between ? and ?";
    //    레스토랑별 예약접수 판매량 조회	(Sql문 보류)
    public String selectBySalesLate = "select  from wine_Order(wine_Order_Amount)res_Resrv_Id=?";
    //     일반회원별 지난예약리스트 조회
    public String selectByLastReserv = "select T2.* from(select rownum rnum, T1.* from(select * from res_Reserv where customer_Id=?)T1)T2 where rnum between ? and ?";
    //     예약접수 추가
    public String insert="insert into res_Reserv(res_Id, customer_Id,res_Resrv_Date,res_Resrv_Fee) values(?,?,?,?)";
    //     예약접수 정보수정
    public String update="update res_Reserv set res_Resrv_Date=?,res_Resrv_Fee=?";
     //    예약접수 정보삭제	
    public String delete="delete from res_Reserv where res_Resrv_Id=?";
     //  예약번호별 예약정보 조회
    public String selectByResReservId ="select * from res_Reserv where res_Reserv_id=?";
}
