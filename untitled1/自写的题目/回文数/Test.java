package 回文数;
//StringBuilder使用场景
//1.字符串的拼接(StringJoiner更好)
//2.字符串的反转
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        System.out.println("请输入一个字符串:");
        String a=sc.next();
        String b=sb.append(a).reverse().toString();//链式编程,只要返回值类型与对象相同就可以这样用
        if(Objects.equals(a, b)){
            System.out.println("该数是回文数");
        }
        else{
            System.out.println("该数不是回文数");
        }
    }
}
