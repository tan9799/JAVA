import java.util.Scanner;
public class jian_pan_lu_ru_shu_ju {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GirlFriend g = new GirlFriend();
        while (true) {
            try {
                System.out.println("请输入名字：");
                String name = sc.nextLine();
                if(name.length() >= 3 && name.length() <= 10) {
                    g.setName(name);
                }
                System.out.println("请输入年龄：");
                String ageString = sc.nextLine();
                int age = Integer.parseInt(ageString);
                g.setAge(age);
                break;
            } catch(NumberFormatException e) {
                e.printStackTrace();
            } catch(AgeOutOfBoundsException e) {
                e.printStackTrace();
            } catch(NameFormatException e) {
                e.printStackTrace();
            }
        }


        System.out.println("名字是：" + g.getName());
    }
}
