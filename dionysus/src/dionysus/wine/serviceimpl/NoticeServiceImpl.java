package dionysus.wine.serviceimpl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.daoimpl.NoticeImpl;
import dionysus.wine.service.NoticeService;

public class NoticeServiceImpl implements NoticeService{
	private NoticeImpl dao;
	public NoticeServiceImpl(NoticeImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	private Logger logger= LoggerFactory.getLogger(BasicInfoServiceImpl.class);

	@Override
	public String readNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String viewsNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
