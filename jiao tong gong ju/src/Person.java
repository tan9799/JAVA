public class Person {
    private String name;
    private int age;
    private char gender;
    public Person(){
    }
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getGender(){
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void drive(Car car) {
        car.move();
        if(car instanceof bicycle) {
            bicycle b = (bicycle)car;
            b.warning();
        } else if(car instanceof qiche) {
            qiche q = (qiche)car;
            q.warning();
        } else {
            System.out.println("没有这个车辆");
        }

    }
}
