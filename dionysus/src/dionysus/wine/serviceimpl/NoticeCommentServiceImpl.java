package dionysus.wine.serviceimpl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.daoimpl.NoticeCommentImpl;
import dionysus.wine.service.NoticeCommentService;

public class NoticeCommentServiceImpl implements NoticeCommentService{
	private NoticeCommentImpl dao;
	public NoticeCommentServiceImpl(NoticeCommentImpl dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	private Logger logger= LoggerFactory.getLogger(BasicInfoServiceImpl.class);

	@Override
	public String readNoticeComment(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createNoticeComment(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateNoticeComment(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteNoticeComment(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
