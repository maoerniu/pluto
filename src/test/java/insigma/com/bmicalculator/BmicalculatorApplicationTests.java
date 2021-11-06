package insigma.com.bmicalculator;

import insigma.com.bmicalculator.service.BMIService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;

//@RunWith( SpringRunner.class)
@SpringBootTest
public class BmicalculatorApplicationTests {

	@Autowired
	BMIService bmiService;

	@Test
	public void calculateBMI() {
		double dResult;
		DecimalFormat df  = new DecimalFormat("0.0");

		dResult = bmiService.CalculateBMI(155.0,52.0);

		//2020/06/20 - Craig - BUDDHA-22 - Failed Test Case
		//2021/11/06 - Craig - IPD-13 - 设置失败的单测用例，用于测试自动通知到OpsGenie
		Assert.assertEquals("21.6", df.format(dResult));
		//Assert.assertEquals("21.5", df.format(dResult));
	}

	@Test
	public void calculateBMIInvalidWeight() {
		double dResult;
		DecimalFormat df  = new DecimalFormat("0.0");

		dResult = bmiService.CalculateBMI(176.0,0.0);
		Assert.assertEquals("0.0", df.format(dResult));
	}

	@Test
	public void calculateBMIInvalidHeight() {
		double dResult;
		DecimalFormat df  = new DecimalFormat("0.0");

		dResult = bmiService.CalculateBMI(0.0,60.0);
		Assert.assertEquals("0.0", df.format(dResult));
	}
}
