package insigma.com.bmicalculator.controller;

import insigma.com.bmicalculator.domain.BMIParam;
import insigma.com.bmicalculator.service.BMIService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BMICalculatorController {

    @PostMapping(value="/calculateBMI")
    public String calculateBMI(@ModelAttribute BMIParam bmi, Model model){
        double dValue;
        String sResult;

        //调用Service核心计算逻辑
        //2020/05/30 - Craig - BUDDHA-17 - Code Refactor for SonarQube Scanner
        //2020/06/20 - Craig - BUDDHA-22 - User management
        //
        BMIService bmicalculator = new BMIService();

        dValue = bmicalculator.CalculateBMI(bmi.getHeight(),bmi.getWeight());

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
            //2021/07/31 - Craig - IPD-8-Bug fix for Withdraw-part-of-policy-current-value
            sResult = String.format("你的体重指数为 %.1f, 属于：偏瘦。", dValue);
        }

        model.addAttribute("bmi",bmi);
        model.addAttribute("Result",sResult);

        return "result";
    }

    @GetMapping("/BMICalculatorPage")
    //2020/05/30 - Craig - BUDDHA-17 - Code Refactor for SonarQube Scanner
    public String bmiCalculatorPage(Model model){
        // 传值给HTML页面动态显示
        BMIParam bmi = new BMIParam();
        bmi.setWeight(90.0);
        bmi.setHeight(180.0);

        model.addAttribute("bmi", bmi);

        return "index";
    }
}