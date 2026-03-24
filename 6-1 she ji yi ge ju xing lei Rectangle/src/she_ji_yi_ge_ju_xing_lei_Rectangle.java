import java.util.Scanner;
class Rectangle {
    private double width;
    private double height;
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

}
public class she_ji_yi_ge_ju_xing_lei_Rectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double w = input.nextDouble();
        double h = input.nextDouble();
        Rectangle myRectangle = new Rectangle(w, h);
        System.out.println(myRectangle.getArea());
        System.out.println(myRectangle.getPerimeter());

        input.close();
    }
}
