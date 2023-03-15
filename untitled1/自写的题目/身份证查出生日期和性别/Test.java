package 身份证查出生日期和性别;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Code s1=new Code();
        while(true) {
            System.out.println("请输入您的身份证号:");
            String Id = sc.next();
            if (Id.length() != 18) {
                System.out.println("输错啦,再试一次");
                continue;
            }
                s1.setId(Id);
                s1.Fun(Id);
                break;
        }
    }
}
