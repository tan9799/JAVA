public class Student {
    private String name;
    private int age;
    public Student(){
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int age(){
        return age;
    }
    public void study() {
        System.out.println("study");
    }
    public void eat(){
        System.out.println("eat");
    }
    public void sleep() {
        System.out.println("sleep");
    }
}
