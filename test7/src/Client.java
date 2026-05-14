public class Client {
    public static void main(String[] args) {
//        Cat c = new Cat();
//        Dog d = new Dog();
//        Person p = new Person();
//        p.feedCat(c);
//        p.feedDog(d);
        //Cat c = new Cat();//创建一只猫
        Animal ani1 = new Cat();//可以把猫当成动物来看，把子类的对象赋值给父类的引用（变量） 向上转型
        Animal ani2 = new Dog();
        Animal ani3 = new DaXiang();

        Person p = new Person();
        p.feed(ani1);
        p.feed(ani2);
        p.feed(ani3);

        //多态：把不同的数据类型进行统一
    }
}
