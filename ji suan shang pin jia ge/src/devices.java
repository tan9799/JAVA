public class devices {
    private String name;
    private double price;
    public devices() {
    }
    public devices(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public double calculate() {
        if(price >= 0 && price < 1000) {
            return price;
        } else if(price < 5000) {
            return price * 0.9;
        } else if(price < 10000) {
            return price * 0.8;
        } else {
            return price * 0.7;
        }
    }
}
