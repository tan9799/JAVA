public class employ {
    private int number;
    private String name;
    private int salary;
    public employ(){
    }
    public employ(int number, String name, int salary) {
        this.number = number;
        this.name = name;
        this.salary = salary;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getSalary(){
        return salary;
    }
    public void work(){
        System.out.println("工作");
    }
    public void eat(){
        System.out.println("吃饭");
    }
}
