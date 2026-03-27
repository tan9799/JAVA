import java.util.Scanner;
class Fan{
    public static final int SLOW = 1;
    public static final int MEDIUM = 1;
    public static final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    public Fan(){
        this.speed = SLOW;
        this.on = false;
        this.radius = 5.0;
        this.color = "white";
    }
    public Fan(int fanSpeed,boolean fanOn,double fanRadius,String fanColor) {
        this.speed = fanSpeed;
        this.on = fanOn;
        this.radius = fanRadius;
        this.color = fanColor;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public boolean getOn(){
        return on;
    }
    public void setOn(boolean on) {
        this.on = on;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String toString(){
        if(on){
            return "speed "+speed+"\n"+"color "+color+"\n"+"radius "+radius+"\n"+"fan is on";
        }
        else{
            return "speed "+speed+"\n"+"color "+color+"\n"+"radius "+radius+"\n"+"fan is off";
        }
    }
}
public class she_ji_yi_ge_feng_shan_Fan_lei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int speed = sc.nextInt();
        String onStr = sc.next();
        boolean on = Boolean.parseBoolean(onStr);
        double radius = sc.nextDouble();
        String color = sc.next();

        Fan fan1 = new Fan();
        Fan fan2 = new Fan(speed, on, radius, color);

        System.out.println("-------");
        System.out.println("Default");
        System.out.println("-------");
        System.out.println(fan1.toString());

        System.out.println("-------");
        System.out.println("My Fan");
        System.out.println("-------");
        System.out.println(fan2.toString());

        sc.close();
    }
}
