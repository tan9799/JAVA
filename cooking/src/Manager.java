public class Manager extends employ{
    private int managesalary;
    public Manager(){
    }
    public Manager(int number, String name, int salary, int managesalary) {
        super(number, name, salary);
        this.managesalary = managesalary;
    }
    public void setManagesalary(int managesalary) {
        this.managesalary = managesalary;
    }
    public int getManagesalary() {
        return managesalary;
    }
    public void work(){
        System.out.println("管理其他人");
    }
}
