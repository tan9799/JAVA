public class Test {
    public static void main(String args[]) {
        Person p = new Person("w", 21, '女');
        System.out.println(p.getName() + "" + p.getAge() + "" + p.getGender());
        bicycle b = new bicycle("飞鸽", 12);
        p.drive(b);
        qiche q = new qiche("保时捷", 120);
        p.drive(q);
    }
}
