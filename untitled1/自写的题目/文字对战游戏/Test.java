package 文字对战游戏;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        List<Role> RoleList = new ArrayList<Role>(10);//创建装10个对象的表
        while (true) {
            Role a = new Role();
            if (n == 0 || n == 1) {
                System.out.println("欢迎来到文字对战平台");
                System.out.println("英雄数量为达到对战条件,请创造英雄:");
                a.setRole();
                RoleList.add(a);//存对象进表
                //System.out.println(RoleList.get(0).getHurt());
                n++;
            } else {
                System.out.println("英雄数量已达到对战条件");
                System.out.println("继续添加---1");
                System.out.println("开始对战---2");
                int z = sc.nextInt();
                if (z == 1) {
                    a.setRole();
                    RoleList.add(a);
                    n++;
                } else {
                    System.out.println("英雄池内信息如下:");
                    for (int i = 0; i < n; i++) {
                        RoleList.get(i).getRole(i);
                    }
                    System.out.println("请输入英雄序号挑选第一位英雄:");
                    int input1 = sc.nextInt();
                    System.out.println("请输入英雄序号挑选第二位英雄:");
                    int input2 = sc.nextInt();
                    input1--;
                    input2--;
                    int a1 = RoleList.get(input1).getHP();
                    //int b1 = RoleList.get(input1).getHurt();
                    String c1 = RoleList.get(input1).getName();
                    int a2 = RoleList.get(input2).getHP();
                    //int b2 = RoleList.get(input2).getHurt();
                    String c2 = RoleList.get(input2).getName();
                    a.battle(a1, c1, a2, c2, RoleList, input1, input2);
                    continue;
                }
            }
        }
    }
}


