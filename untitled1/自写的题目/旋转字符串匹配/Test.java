package 旋转字符串匹配;

import java.util.Scanner;

//方法一:通过subString截取字符串到StringBuild里面操作并返还,将返还的值与输入的比较
//方法二:给定两个字符串A,B,如果字符串A在经过若干次旋转后与B相等则返回True反之。旋转的意思是将A的第一个字符移动到最后一个字符
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = 0;
            System.out.print("请输入字符串A:");
            String A = sc.next();
            System.out.print("请输入字符串B:");
            String B = sc.next();
            char[] Tmp = new char[A.length()];
            if (A.length() != B.length()) {
                System.out.println("字符串长度不一样哦,无法比较");
            } else {
                for (int i = 0; i < A.length(); i++) {
                    if (i == 0) {
                        for (int j = 0; j < A.length() - 1; j++) {
                            Tmp[j] = A.charAt(j + 1);
                        }
                        Tmp[A.length() - 1] = A.charAt(i);
                    } else {
                        char arr = Tmp[0];
                        for (int j = 0; j < A.length() - 1; j++) {
                            Tmp[j] = Tmp[j + 1];
                        }
                        Tmp[A.length() - 1] = arr;
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < A.length(); j++) {
                            sb.append(Tmp[j]);
                        }
                        String Tmp1 = sb.toString();
                        if (Tmp1.equals(B)) {
                            a++;
                        }
                    }
                }
                if (a != 0)
                    System.out.println("True");
                else
                    System.out.println("False");
                break;
            }
        }
    }
}