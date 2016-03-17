package echarts_demo.job.orders;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjjf.analysis.services.SpOrderDetailServiceJobImpl;

public class AnaSpOrderDetailJob {

	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void should_send_a_amq_message() throws Exception {

		SpOrderDetailServiceJobImpl spOrderInfoServcie = (SpOrderDetailServiceJobImpl) context.getBean("spOrderDetailServiceJobImpl");
		spOrderInfoServcie.excuse_orderDetail();
	}

}
