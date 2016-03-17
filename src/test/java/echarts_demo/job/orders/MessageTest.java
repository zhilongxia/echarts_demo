package echarts_demo.job.orders;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjjf.analysis.services.SpOrderInfoServiceJobImpl;

public class MessageTest {

	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void should_send_a_amq_message() throws Exception {

		SpOrderInfoServiceJobImpl spOrderInfoServcie = (SpOrderInfoServiceJobImpl) context.getBean("spOrderInfoServiceJobImpl");
		spOrderInfoServcie.excuse();
	}

}
