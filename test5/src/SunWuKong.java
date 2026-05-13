public class SunWuKong extends Hero{
    String name = "孙大圣";
    public SunWuKong() {
        System.out.println("我是子类的构造方法");
    }
    public void chi() {
        //先找自己类，再找父类
        System.out.println(this.name + "在吃桃子");
        //如果此时想看到父类中的内容
        System.out.println(super.name + "在吃桃子");
    }
    public static void main(String[] args) {
        SunWuKong s = new SunWuKong();
        s.chi();
    }
}
