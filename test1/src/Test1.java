public class Test1 {
    String name;
    String skill_q;
    String skill_w;
    String skill_e;
    String skill_r;
    public Test1(String name) {
        this.name = name;
    }
    public Test1(String name, String skill_q, String skill_w, String skill_e, String skill_r) {
        this(name);
        this.skill_q = skill_q;
        this.skill_e = skill_e;
        this.skill_w = skill_w;
        this.skill_r = skill_r;
    }
    public void fight(){
        System.out.println(this.name + "上阵杀敌");
    }
    public static void main(String[] args){
        Test1 T = new Test1("gailun", "qian", "hou", "zuo", "you");
        T.fight();
    }
}
