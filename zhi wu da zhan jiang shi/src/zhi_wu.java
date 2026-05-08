public class zhi_wu {
    String name;
    int hp;
    int attack;
    public zhi_wu(String name, int hp, int attack){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }
    public void fight(jiang_shi js) {
        System.out.println(this.name + "正在被吃" + js.name);
        js.hp -= this.attack;
        System.out.println(js.hp);
    }
}
