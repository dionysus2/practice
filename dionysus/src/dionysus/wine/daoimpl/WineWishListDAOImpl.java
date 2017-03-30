package dionysus.wine.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dionysus.wine.dao.WineWishListDAO;
import dionysus.wine.query.WineWishListQuery;
import dionysus.wine.util.JDBCUtil;

public class WineWishListDAOImpl implements WineWishListDAO {

	//	장바구니 상품담기
	 @Override
	public int wineWishListInsert(Connection conn, int customerId, int wineInfoId) throws SQLException  {
		// TODO Auto-generated method stub
		 PreparedStatement pstm= null;
		 try {
			pstm= conn.prepareStatement(WineWishListQuery.insertWineWishList);
			pstm.setInt(1, customerId);
			pstm.setInt(2, wineInfoId);
			return pstm.executeUpdate();
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		 finally{
			 JDBCUtil.close(pstm, null);
		 }
	}
	 //	장바구니 상품삭제
	@Override
	public int wineWishListDelete(Connection conn, int customerId, int wineInfoId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstm= null;
		 try {
			pstm= conn.prepareStatement(WineWishListQuery.deleteWineWishList);
			pstm.setInt(1, customerId);
			pstm.setInt(2, wineInfoId);
			return pstm.executeUpdate();
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		 finally{
			 JDBCUtil.close(pstm, null);
		 }
	}
}
