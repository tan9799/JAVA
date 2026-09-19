public class Test {
    public static void main(String args[]) {
        student s = new student();
        s.setName("张三");
        s.setAge(18);
        s.setHeight(183);
        s.setWeight(60);
        int newweight = s.getWeight() + 10;
        s.setWeight(newweight);

    }
}
