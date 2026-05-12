import java.util.Scanner;
public class tian_bu_jia_nian{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int age;
        age = in.nextInt();
        Person p = new Person(age);
        age = in.nextInt();
        try{
            p.setAge(age);
            System.out.println("A");
        }catch(AgeException e){
            System.out.println("B");
        }
    }
}
class Person{
    int age;
    public Person(int age){
        this.age = age;
    }
    public void setAge(int age) throws AgeException {
        if(this.age <= age){
            this.age = age;
        }else{
            throw new AgeException();
        }
    }
}
class AgeException extends Exception{
}
