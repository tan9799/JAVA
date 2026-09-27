public class VariableDemo1 {
    public static void main(String[] args) {
        /*
        算数运算符：+ - * / %
        整数计算、小数计算
         */
        //1.整数计算
        int a = 10;
        int b = 3;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println("------------------");
        //2.小数计算
        //细节：
        //    小数直接参与计算，结果有可能不精确
        double c = 10.1;
        double d = 3.1;
        System.out.println(c + d);
        System.out.println(c - d);
        System.out.println(c * d);
        System.out.println(c / d);
        System.out.println(c % d);
        System.out.println("------------------");
    }
}
