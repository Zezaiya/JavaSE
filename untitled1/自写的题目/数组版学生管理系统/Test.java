package 数组版学生管理系统;

import java.util.Objects;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Student1[] arr=new Student1[10];
        Scanner sc=new Scanner(System.in);
        int count=0;
        while(true){
            if(count==0) {
                System.out.println("请先为数据进行初始化");
                System.out.print("学号:");
                String Id = sc.next();
                System.out.print("姓名:");
                String Name = sc.next();
                System.out.print("年龄:");
                int Age = sc.nextInt();
                Student1 s1 = new Student1(Id, Name, Age);
                arr[0] = s1;
                count++;
            }
               System.out.println("请选择您的功能");
               System.out.println("查看学生----1");
               System.out.println("添加学生----2");
               System.out.println("删除学生----3");
               System.out.println("修改信息----4");
               System.out.println("退出系统----0");
               int input=sc.nextInt();
               switch(input){
                   case 1:
                       Display(count,arr);
                       break;
                   case 2:
                       count++;
                       Add(count,arr);
                       break;
                   case 3:
                       Delete(count,arr);
                       count--;
                       break;
                   case 4:
                       //Alter(count,arr);
                       break;
                   case 0:
                       return;
                   default:
                       System.out.println("您输入的值有误,请重新输入");
                       System.out.println("\n");
                       break;
               }
           }
    }
    public static void Display(int count, Student1[] arr){
        System.out.println("系统内共有"+count+"名学生,信息如下");
        for (int i = 0; i < count; i++) {
            System.out.print("学号:");
            System.out.println(arr[i].getId());
            System.out.print("姓名:");
            System.out.println(arr[i].getName());
            System.out.print("年龄:");
            System.out.println(arr[i].getAge());
            System.out.println("\n");
        }
    }

    public static void Add(int count, Student1[] arr){
        Scanner sc=new Scanner(System.in);
        Student1 s1 = new Student1();
        while(true) {
            System.out.print("学号:");
            String Id = sc.next();
            int b = 0;
            for (int i = 0; i < count - 1; i++) {
                String aId = arr[i].getId();
                int a = arr[i].Judge(aId, Id);
                if (a == 0) {
                    b++;
                }
            }
            if (b != 0) {
                System.out.println("学号已存在,请重试!");
                continue;
            }
            s1.setId(Id);
            System.out.print("姓名:");
            String Name = sc.next();
            s1.setName(Name);
            System.out.print("年龄:");
            int Age = sc.nextInt();
            s1.setAge(Age);
            System.out.println("添加成功!");
            arr[count - 1] = s1;
            break;
        }
    }

    public static void Delete(int count, Student1[] arr){
        int b=0;
        Student1[] arr1=new Student1[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号删除对应学生");
        String str=sc.next();
        for (int i = 0; i < count; i++) {
            if(Objects.equals(str, arr[i].getId())){
                b++;
                continue;
            }
            arr1[i]=arr[i];
        }
        if(b==0)
         System.out.println("无该学号学生,删除失败");
        else
         System.out.println("删除成功!");
    }
}
