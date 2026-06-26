import java.util.Scanner;
public class you_xi_ren_wu_de_xue_tiao {
    public static void main(String args[]) {
        int blood = 200;
        Scanner sc = new Scanner(System.in);
        int hurt = 0;
        while(true) {
            System.out.println("请输入攻击力：");
            hurt = sc.nextInt();
            if(hurt > 0) {
                break;
            } else {
                System.out.println("输入的攻击力有误，请重新输入：");
            }
        }
        blood -= hurt;
        if(blood <= 0) {
            blood = 1;
        }
        int skill = 0;
        while(true) {
            System.out.println("请输入技能效果：");
            skill = sc.nextInt();
            if(skill > 0) {
                break;
            } else {
                System.out.println("输入的技能效果有误，请重新输入：");
            }
        }
        blood += skill;
        if(blood > 200) {
            blood = 200;
        }
        System.out.println("当前游戏人物的血量是：" + blood);

    }
}
