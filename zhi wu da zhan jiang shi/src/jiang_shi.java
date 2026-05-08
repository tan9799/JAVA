public class jiang_shi {
    String name;
    int hp;
    int attack;
    public jiang_shi(String name, int hp, int attack){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }
    public void eat(zhi_wu zw) {
        System.out.println(this.name + "正在吃" + zw.name);
        zw.hp -= this.attack;
        System.out.println(zw.hp);
    }
}
