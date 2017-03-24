package dionysus.wine.query;

public interface ResResrvInfoQuery {
	 //      예약 추가
    public String insert="insert into res_Reserv_Info(res_Id, res_Reserv_Id, res_Resrv_Info_Booking_Seats) values(?,?,?)";
    //      예약 삭제	
    public String delete="delete from res_Reserv_Info where res_Reserv_Id=? and res_Info_Id=?";
    //      예약 변경
    public String update="update res_Reserv_Info set res_Id=?,res_Reserv_Id=?,res_Resrv_Info_Booking_Seats=?";

}
