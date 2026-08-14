public class Test {
    public static void main(String args[]) {
        phone p = new phone();
        p.setName("小米");
        p.setPrice(4999.0);
        System.out.println("手机的名称是：" + p.getName() + " 手机的价格是：" + p.calculate());
        laptop l = new laptop();
        l.setName("联想");
        l.setPrice(10000);
        System.out.println("笔记本的名称是：" + l.getName() + " 笔记本的价格是：" + l.calculate());
        PAD pad = new PAD();
        pad.setName("华为");
        pad.setPrice(5000);
        System.out.println("平板的名称是：" + pad.getName() + " 平板的价格是：" + pad.calculate());
    }
}
