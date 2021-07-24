package insigma.com.bmicalculator;

import insigma.com.bmicalculator.domain.BMIParam;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BmiParamTests {

    @Test
    public void testConstructor() {
        final double dHeight = 180;
        final double dWeight = 80;

        BMIParam bmiParam = new BMIParam( dHeight,dWeight);

        Assert.assertEquals(dHeight,bmiParam.getHeight(),0);
        Assert.assertEquals(dWeight,bmiParam.getWeight(),0);

        bmiParam.setHeight(100);
        Assert.assertEquals(100,bmiParam.getHeight(),0);

        bmiParam.setWeight(50);
        Assert.assertEquals(50,bmiParam.getWeight(),0);
    }

    @Test
    public void testNullValue() {
        BMIParam bmiParam = new BMIParam();

        Assert.assertNotNull(bmiParam.getHeight());
        Assert.assertNotNull(bmiParam.getWeight());

        Assert.assertEquals(0,bmiParam.getHeight(),0);
        Assert.assertEquals(0,bmiParam.getWeight(),0);
    }

    @Test
    public void testToString()
    {
        BMIParam bmiParam = new BMIParam(180,80);
        String expected = "BMIParam{height=180.0, weight=80.0}";

        Assert.assertEquals(expected, bmiParam.toString());
    }
}