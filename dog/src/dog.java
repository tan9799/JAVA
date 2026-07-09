public class dog {
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void bone(){
        System.out.println(age + "岁的" + name + "正在吃骨头");
    }
}
