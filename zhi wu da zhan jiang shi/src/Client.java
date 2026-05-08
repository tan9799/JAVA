public class Client {
    public static void main(String[] args) {
        zhi_wu zw = new zhi_wu("豌豆", 1000, 5);
        jiang_shi js = new jiang_shi("铁桶僵尸", 800, 20);
        zw.fight(js);
        js.eat(zw);
    }
}
