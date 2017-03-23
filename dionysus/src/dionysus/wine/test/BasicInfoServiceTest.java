package dionysus.wine.test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.serviceimpl.BasicInfoServiceImpl;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BasicInfoServiceTest {
	private BasicInfoDAOImpl dao= new BasicInfoDAOImpl();
	private BasicInfoServiceImpl service= new BasicInfoServiceImpl(dao);
	private Logger logger= LoggerFactory.getLogger(BasicInfoServiceTest.class);
	@Test
	public void insertEndTest(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		given(request.getParameter("basicInfoUsername")).willReturn("ttest");
		given(request.getParameter("basicInfoPwd")).willReturn("1234");
		given(request.getParameter("basicInfoEmail")).willReturn("test@naver.com");
		String result= service.createEnd(request);
		logger.info(result);
		assertThat(result, is("{\"result\":\"success\"}"));
	}
}
