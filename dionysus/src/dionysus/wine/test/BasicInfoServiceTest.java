package dionysus.wine.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dionysus.wine.daoimpl.BasicInfoDAOImpl;
import dionysus.wine.serviceimpl.BasicInfoServiceImpl;

public class BasicInfoServiceTest {
	private BasicInfoDAOImpl dao= new BasicInfoDAOImpl();
	private BasicInfoServiceImpl service= new BasicInfoServiceImpl(dao);
	private Logger logger= LoggerFactory.getLogger(BasicInfoServiceTest.class);
	//	@Test 						
	//	성공
	public void insertEndTest(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		given(request.getParameter("basicInfoUsername")).willReturn("ttest");
		given(request.getParameter("basicInfoPwd")).willReturn("1234");
		given(request.getParameter("basicInfoEmail")).willReturn("test@naver.com");
		String result= service.createEnd(request);
		logger.info(result);
		assertThat(result, is("{\"result\":\"success\"}"));
	}
	//	@Test
	//	성공
	public void loginTest(){
		HttpServletRequest request= mock(HttpServletRequest.class);
		given(request.getParameter("basicInfoUsername")).willReturn("ADMIN2");
		given(request.getParameter("basicInfoPwd")).willReturn("1234");
		String result= service.login(request);
		logger.info(result);
		assertThat(result, is("{\"result\":\"success\"}"));
	}
	//	아이디 중복테스트 성공했습니다.
}
