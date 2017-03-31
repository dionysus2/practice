package dionysus.wine.query;

public interface ResInfoQuery {
	
//	레스토랑 정보 페이지별 리스트 조회
	public String selectResInfoAllList = "select T2.* from(select rownum rnum, T1.* from(select * from res_Info)T1)T2 where rnum between ? and ?";      
	//      레스토랑 정보 count조회	
    public String selectCount = "select count(*)from res";
	//	레스토랑 정보 업주별 조회
   public String selectByResOwnerResInfo = "select T2.* from(select rownum rnum, T1.* from(select * from res_Info where res_Id=?)T1)T2 where rnum between ? and ?";       
   //      레스토랑 정보 업주별 count조회	
   public String ResOwnerResInfoCount = "select count(*)from res where res_Id=?";    
   //	레스토랑 정보 추가
	public String insert="insert into res_info(res_Info_Id, res_Info_Name,res_Info_Picture1,res_Info_Picture2,res_Info_Picture3,res_Info_Available_Seat,res_Info_Opening_Hours,res_Info_Website,res_Id) values(?,?,?,?,?,?,?,?,?)";
	//	레스토랑 정보 삭제
	public String delete="delete from res_info where res_Id=?";
	//	레스토랑 정보 수정
	public String update="update res_info set res_Info_Id=?, res_Info_Name=?,res_Info_Picture1=?, res_Info_Picture2=?, res_Info_Picture3=?, res_Info_Available_Seat=?, res_Info_Opening_Hours=?, res_Info_Website=?,res_Id=?";
    //	레스토랑번호별 정보 조회
    public String selectByResInfoId ="select * from res_info where res_info_id=?";	
    //      BasicInfoUsername별 resId 찾기
    public String selectByResId = "select r.res_Id from res_Info r, basic_Info b where b.basic_Info_id = r.res_id and b.basic_Info_Username=?";	
}
