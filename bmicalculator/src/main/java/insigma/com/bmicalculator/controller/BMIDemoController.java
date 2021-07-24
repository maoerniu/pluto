package insigma.com.bmicalculator.controller;

import insigma.com.bmicalculator.domain.BMIParam;
import insigma.com.bmicalculator.service.BMIService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class BMIDemoController {

    //http://localhost:8011/calcBMI?Height=180&Weight=90
    //返回文本结果
    @PostMapping("/calcBMI")
    public String calcBMI(@RequestBody BMIParam param){
        double dHeight = param.getHeight();
        double dWeight = param.getWeight();
        double dBMIValue;

        BMIService bmiCalculator = new BMIService();
        dBMIValue = bmiCalculator.CalculateBMI(dHeight,dWeight);
        //2020/05/30 - Craig - BUDDHA-17 - Code Refactor for SonarQube Scanner （\r\n -> %n）
        return String.format("您的身高是: %.1f 厘米 %n您的体重是： %.1f 公斤 %n您的身体质量指数（Body Mass Index）为：%.1f" , dHeight, dWeight, dBMIValue);
    }

    //http://localhost:8011/calcBMIV2?Height=180&Weight=90
    //返回JSON结果
    //2020/05/30 - Craig - BUDDHA-17 - Code Refactor for SonarQube Scanner
    //@RequestMapping(path={"/calcBMIV2"})
    @GetMapping(path="/calcBMIV2")
    public HashMap<String,Object> calcBMIV2(@RequestParam(value = "Height",required = true) double dHeight, @RequestParam(value = "Weight",required = true) double dWeight){
        double dValue;
        String sResult = "";
        HashMap<String,Object> map=new HashMap<>();

        BMIService bmiCalculator = new BMIService();
        dValue = bmiCalculator.CalculateBMI(dHeight,dWeight);

        if(dValue>30){
            sResult = String.format("您的体重指数为 %.1f, 属于：肥胖。", dValue);
        }
        else if (dValue>=25 && dValue <=30){
            sResult = String.format("您的体重指数为 %.1f, 属于：超重。", dValue);
        }
        else if (dValue>=18.5 && dValue <25){
            sResult = String.format("您的体重指数为 %.1f, 属于：正常。", dValue);
        }
        else{
            sResult = String.format("您的体重指数为 %.1f, 属于：偏瘦。", dValue);
        }

        map.put("Weight", String.valueOf(dWeight));
        map.put("Height", String.valueOf(dHeight));
        map.put("Value", String.format("%.1f", dValue));
        map.put("Result", sResult);
        return map;
    }

    /*
    构建Restful编程风格
     */
    //2020/05/30 - Craig - BUDDHA-17 - Code Refactor for SonarQube Scanner
    //@RequestMapping(path = {"/getSumResult"},method= RequestMethod.GET)
    @GetMapping(path="/getSumResult")
    public String getSumResult(@RequestParam(value="value",required = false) int param){
        int result1 = 5 + param;

        return String.format("Add 5 to %d is %d.", param, result1);
    }
}