public class bi_jiao_mian_ji_da_xiao {
    public static void main(String args[]) {
        double eln1 = 10.1;
        double width1 = 5.2;

        double eln2 = 20.2;
        double width2 = 5.0;

        double area1 = getArea(eln1, width1);
        double area2 = getArea(eln2, width2);

        if(area1 > area2) {
            System.out.println("第一个长方形面积大");
        } else {
            System.out.println("第二个长方形面积大");
        }
    }
    public static double getArea(double a, double b) {
        return a * b;
    }
}
