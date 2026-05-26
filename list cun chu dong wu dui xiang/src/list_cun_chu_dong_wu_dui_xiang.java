import java.util.*;

// 1. 定义抽象类 Animal
abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + "]";
    }
}

// 2. Bird 子类
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Bird[name=" + getName() + ", age=" + getAge() + "]";
    }
}

// 3. Dog 子类
class Dog extends Animal {
    private int leg;

    public Dog(String name, int age, int leg) {
        super(name, age);
        this.leg = leg;
    }

    public int getLeg() { return leg; }
    public void setLeg(int leg) { this.leg = leg; }

    @Override
    public String toString() {
        return "Dog[leg=" + leg + ", name=" + getName() + ", age=" + getAge() + "]";
    }
}

public class list_cun_chu_dong_wu_dui_xiang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 处理多组输入直到文件结束
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            List<Animal> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int type = sc.nextInt();
                if (type == 1) { // Dog
                    String name = sc.next();
                    int age = sc.nextInt();
                    int leg = sc.nextInt();
                    list.add(new Dog(name, age, leg));
                } else { // Bird
                    String name = sc.next();
                    int age = sc.nextInt();
                    list.add(new Bird(name, age));
                }
            }
            // 输出整个列表
            System.out.println(list);
            // 查询
            String query = sc.next();
            boolean found = false;
            for (Animal a : list) {
                if (a.getName().equals(query)) {
                    System.out.println(a.getClass().getSimpleName());
                    System.out.println(a);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("no this one");
            }
        }
        sc.close();
    }
}