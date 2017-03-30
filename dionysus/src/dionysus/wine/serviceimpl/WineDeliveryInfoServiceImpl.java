package dionysus.wine.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import dionysus.wine.daoimpl.WineDeliveryInfoDaoImpl;
import dionysus.wine.service.WineDeliveryInfoService;
import dionysus.wine.util.JDBCUtil;
import dionysus.wine.vo.WineDeliveryInfo;

public class WineDeliveryInfoServiceImpl implements WineDeliveryInfoService {
	private WineDeliveryInfoDaoImpl dao;
	public WineDeliveryInfoServiceImpl(WineDeliveryInfoDaoImpl dao){
		this.dao=dao;
	}
		
	@Override
	public String createWineDeliverInfo(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineDeliveryId = Integer.parseInt(req.getParameter("wineDeliveryid"));
		int wineInfoId = Integer.parseInt(req.getParameter("wineInfoId"));
		int wineDeliveryInfoCount = Integer.parseInt("wineDeliveryInfoCount");
		try {
			int result = dao.insertWineDeliveryInfoId(conn, new WineDeliveryInfo(wineDeliveryId,wineInfoId,wineDeliveryInfoCount));
			return new Gson().toJson(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String deleteWineDeliveryInfo(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineDeliveryId=Integer.parseInt(req.getParameter("wineDeliveryId"));
		try {
			int result=dao.deleteWineDeliveryInfoId(conn, wineDeliveryId);
			return new Gson().toJson(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return null;
	}

	@Override
	public String updateWineDeliveryInfo(HttpServletRequest req) {
		Connection conn = JDBCUtil.getConnection();
		int wineDeliveryId= Integer.parseInt(req.getParameter("wineDeliveryId"));
		int wineDeliveryInfoCount = Integer.parseInt(req.getParameter("wineDeliveryInfoCount"));
		try {
			int result=dao.updateWineOrder(conn, wineDeliveryId, wineDeliveryInfoCount);
			return new Gson().toJson(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn);
		}
		return null;
	}


}
