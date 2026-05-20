import java.util.*;
class People{
    private String name;
    private int age;
    People(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String toString() {
        return "[ "+name+" ,"+age+" ]";
    }
}

public class Test {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        List<People> list = new ArrayList<>(); // 创建列表
        for(int i=0;i<3;i++) {
            list.add(new People(sc.next(), sc.nextInt())); // 输入3个People对象加入列表
        }
        System.out.println(list.size()); // 输出列表元素个数
        System.out.println(list);
    }
}