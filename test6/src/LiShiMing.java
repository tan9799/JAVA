public class LiShiMing extends LiYuan{
    //子类中的方法必须和父类中的方法完全一致
    public void makeCountry(){
        super.makeCountry();//super可以调用父类中被重写了的内容
        System.out.println("李世明也想建立一个自己的国家");
    }
    public static void main(String[] args) {
        LiShiMing l = new LiShiMing();
        l.makeCountry();
    }
}
