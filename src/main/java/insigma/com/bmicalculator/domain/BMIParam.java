package insigma.com.bmicalculator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
set和get必须符合驼峰命名规范
 */
public class BMIParam implements Serializable {

    //这里BMIParam的两个属性字段
    @NotNull(message = "身高不能为空！")
    @JsonProperty(value = "Height")
    private double dHeight; //身高

    @NotNull(message = "体重不能为空！")
    @JsonProperty(value = "Weight")
    private double dWeight; //体重

    public BMIParam(){
        dHeight = 0;
        dWeight = 0;
    }

    public BMIParam(double height,double weight) {
        this.dHeight=height;
        this.dWeight=weight;
    }

    public void setHeight(double height){
        this.dHeight = height;
    }

    public double getHeight(){
        return dHeight;
    }

    public void setWeight(double weight){
        this.dWeight=weight;
    }

    public double getWeight(){
        return dWeight;
    }

    @Override
    public String toString() {
        return "BMIParam{" +
                "height=" + dHeight +
                ", weight=" + dWeight + "}";
    }
}
