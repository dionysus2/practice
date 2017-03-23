package dionysus.wine.query;

public interface CustomerQuery {
	public String insert = "insert into customer(Customer_id, Customer_UserName, Customer_Pwd, Customer_Rrn , Customer_Address, Customer_Name, Customer_Tel, Customer_Gender, Customer_AccountNo, Customer_Job, Customer_Email, Customer_Activated) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	public String update = "update customer set pwd=?, rrn=?, address=?, name=?, tel=?, gender=?, accountNo=?, job=?, email=?, activated=? where customer_id=?";
	public String delete = "delete from customer where Customer_id=?";
	public String customerList = "select * from customer where Customer_Id";
	public String customerAllCount="select count(CUSTOMER_ID) from customer";
	public String customerAge = "select * from customer where Customer_Age=?";	
	public String customerJob = "select * from customer where Customer_Job=?";
	public String customerGender = "select * from customer where Customer_Gender=?";
	public String customerName = "select * from customer where Customer_Name=?";
	public String login = " select count(*) from customer where Customer_UserName=?, and Customer_Pwd=?";
	public String selectUserName = "select Customer_UserName from customer where Customer_Name=? Customer_Rrn=?";
	public String selectPwd = "select Customer_Pwd from customer where Customer_UserName=?, Customer_Name=?, Customer_Rrn=?";
	public String selectResReserv = "select * from Res_Reserv r, customer c where r.Res_Reserv_Id=c.Customer_Id";
	public String updateResReserv = "update Res_Reserv set Res_Reserv_Date=?, Res_Reserv_Fee=? where Customer_Id=?";
	public String deleteResReserv = "delete from Res_Reserv where Customer_Id=?";
	//회원 레스토랑 년별 지난예약 조회
	//public String selectLastResReserv = 
	public String selectWineOrder = "select * from Wine_Order w, customer c where w.Wine_Order_Id=c.Customer_Id";
	public String updateWineOrder = "update Wine_Order set Wine_Order_Date=?, Wine_Order_Amount=? where Customer_Id=?";
	public String deleteWineOrder = "delete from Wine_Order where Customer_Id=?";
	public String selectWineWishList = "select * from Wine_WishList ww, customer c where ww.Wine_WishList_Id=c.Customer_Id";
	//회원 장바구니 와인상품 주문
	//public String OrderWineWishList =                                                                      
	public String deleteWineWishList = "delte from Wine_WishList where Customer_Id=?";
}
