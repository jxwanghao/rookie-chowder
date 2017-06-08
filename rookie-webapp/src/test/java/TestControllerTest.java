import com.jxwanghao.rookie.webapp.controller.TokenController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单元测试 controller超类
 * 
 * @author jiangmy
 * @date 2017-04-20 09:23:33
 * @since v1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration("classpath:/spring/spring.xml") })
@Transactional(transactionManager = "transactionManager")
public class TestControllerTest {

	@Autowired
	private TokenController tokenController;

	@Test
	public void testSaveToken() {
		tokenController.saveToken();
	}

}
