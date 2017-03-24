package dionysus.wine.query;

public interface ResReviewQuery {
	 //      리뷰 추가
    public String insert="insert into Res_Reivew(res_Review_Id, res_Review_Content,res_Review_Ratings,customer_Id,wine_Info_Id) values(?,?,?,?,?)";
    //      리뷰 변경
    public String update="update Res_Reivew set res_Review_Id=?,res_Review_Content=?, res_Review_Ratings=? where customer_Id=? and wine_Info_Id=?";
    //      리뷰 삭제	
    public String delete="delete from Res_Reivew where customer_Id=? and wine_Info_Id=?";
    //     레스토랑별 리뷰정보 전체리스트 조회
    public String selectAllResReview = "select * from res_Review where res_Info_Id=?";

}
