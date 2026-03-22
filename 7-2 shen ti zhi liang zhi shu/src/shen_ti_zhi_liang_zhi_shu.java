import java.util.Scanner;
public class shen_ti_zhi_liang_zhi_shu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double height = sc.nextDouble();
        if(weight > 727 | height > 2.72){
            System.out.println("input out of range");
            return;
        }
        double BMI = weight / (height * height);
        if (BMI < 18.5){
            System.out.println("thin");
        }else if(BMI >= 18.5 & BMI < 24){
            System.out.println("fit");
        }else if(BMI >= 24 & BMI < 28){
            System.out.println("overweight");
        }else{
            System.out.println("fat");
        }
    }
}
