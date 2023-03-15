package 手机号屏蔽;
//思路1:将字符串类型的电话号码存入数组中,将数组中间四位用*号代替
//思路2:使用substring方法获取电话号码前三位和后四位分别存入两个字符串中,结果则为字符串1+"****"+字符串2
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {//思路一
        Phone s1=new Phone();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("请输入您的手机号");
            String tel = sc.next();
           int a=s1.Judge(tel);
           if(a==0)
           {
               System.out.println("您输入的手机号有误,请重新输入");
               continue;
           }
            s1.setTel(tel);
            s1.Fun(tel);
            System.out.println("屏蔽成功,屏蔽后的号码为:"+s1.getTel());
            break;
        }
    }
    /*public static void main(String[] args) {//思路二
        Scanner sc=new Scanner(System.in);
        Phone s1=new Phone();
        while(true) {
            System.out.println("请输入您的手机号");
            String tel = sc.next();
            int a=s1.Judge(tel);
            if(a==0)
            {
                System.out.println("您输入的手机号有误,请重新输入");
                continue;
            }
            s1.setTel(tel);
           String arr1=s1.getTel().substring(0,3);
           String arr2=s1.getTel().substring(7);//从7开始到结束
           String result=arr1+"****"+arr2;
            System.out.println("屏蔽成功,屏蔽后的号码为:"+result);
            break;
        }
    }*/
}

