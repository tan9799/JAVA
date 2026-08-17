public class bicycle extends Car{
    public bicycle(){
    }
    public bicycle(String brand, int speed) {
        super(brand, speed);
    }
    public void warning(){
        System.out.println("响铃");
    }
}
