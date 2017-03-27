package dionysus.wine.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;

import dionysus.wine.daoimpl.WineInfoDAOImpl;
import dionysus.wine.serviceimpl.WineInfoServiceImpl;

public class WineInfoServiceTest {
	private WineInfoDAOImpl dao= new WineInfoDAOImpl();
	private WineInfoServiceImpl service= new WineInfoServiceImpl(dao);
	//	@Test
	//	성공~ 결과 출력됨.
	public void readByWineInfoIdTest(){
		HttpServletRequest request= mock(HttpServletRequest.class);
		given(request.getParameter("wineInfoId")).willReturn("21");
		String result= service.readByWineInfoId(request);
		assertThat(result, is(1));
	}
}
