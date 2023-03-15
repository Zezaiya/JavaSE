package 继承结构标准Javabean;

public class Test {
    public static void main(String[] args) {
        Cook s1=new Cook("1","厨师",2500);
        Manager s2=new Manager("0","经理",5000,10000);
        System.out.print(s1.getName());
        s1.Work();
        System.out.print(s1.getName());
        s1.Eat();
        System.out.print(s2.getName());
        s2.Work();
        System.out.print(s2.getName());
        s2.Eat();
    }
}
