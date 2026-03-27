import java.util.Scanner;
class Vehicle{
    private String kind;
    private double speed;
    private String color;
    public void setKind(String kind){
        this.kind= kind;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getKind(){
        return kind;
    }
    public double getSpeed(){
        return speed;
    }
    public String getColor(){
        return color;
    }
}

public class she_ji_jiao_tong_gong_ju_lei_Vehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle();
        v1.setKind(sc.nextLine());
        v1.setSpeed(sc.nextDouble());
        sc.nextLine();
        v1.setColor(sc.nextLine());
        v2.setKind(sc.nextLine());
        v2.setSpeed(sc.nextDouble());
        sc.nextLine();
        v2.setColor(sc.nextLine());

        System.out.printf("第一辆是%s，时速为%.1fkm/h，颜色为%s\n",
                v1.getKind(), v1.getSpeed(), v1.getColor());
        System.out.printf("第二辆是%s，时速为%.1fkm/h，颜色为%s\n",
                v2.getKind(), v2.getSpeed(), v2.getColor());

        sc.close();
    }
}
