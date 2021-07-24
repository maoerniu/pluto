package insigma.com.bmicalculator.service;

import org.springframework.stereotype.Component;

@Component
public class BMIService {
    // 输入体重（公斤）、身高（厘米），计算BMI=体重（公斤）/身高（米）平方
    //75KM 175CM BMI=75/1.75×1.75=24.49

    public double CalculateBMI(double dHeight, double dWeight){
        double dResult;

        //这是业务代码，test comment on 2021/02/10
        if(dHeight != 0.0){
            dResult =dWeight /((dHeight/100)*(dHeight/100));
        }
        else {
            dResult = 0.0;
        }

        return 1.0*dResult;
    }
}

