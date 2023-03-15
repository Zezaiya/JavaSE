package 集合版学生管理系统;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student2> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (list.size() == 0) {
                System.out.println("请先为数据进行初始化");
                System.out.print("学号:");
                String Id = sc.next();
                System.out.print("姓名:");
                String Name = sc.next();
                System.out.print("年龄:");
                int Age = sc.nextInt();
                Student2 s1 = new Student2(Id, Name, Age);
                list.add(s1);
            }
            System.out.println("请选择您的功能");
            System.out.println("查看学生----1");
            System.out.println("添加学生----2");
            System.out.println("删除学生----3");
            System.out.println("修改信息----4");
            System.out.println("退出系统----0");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    Display(list);
                    break;
                case 2:
                    Add(list);
                    break;
                case 3:
                    Delete(list);
                    break;
                case 4:
                    Alter(list);
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

    public static void Display(ArrayList<Student2> list) {
        if (list.size() == 0) {
            System.out.println("系统内暂无学生信息，请重试");
            System.out.println("\n");
            return;
        }
        System.out.println("系统内有" + list.size() + "名学生,信息如下");
        for (Student2 student2 : list) {
            System.out.print("学号:");
            System.out.println(student2.getId());
            System.out.print("姓名:");
            System.out.println(student2.getName());
            System.out.print("年龄:");
            System.out.println(student2.getAge());
            System.out.println("\n");
        }
    }

    public static void Add(ArrayList<Student2> list) {
        Scanner sc = new Scanner(System.in);
        Student2 s1 = new Student2();
        while (true) {
            System.out.print("学号:");
            String Id = sc.next();
            int b = 0;
            for (Student2 student2 : list) {
                String aId = student2.getId();
                int a = student2.Judge(aId, Id);
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
            list.add(s1);
            break;
        }
    }

    public static void Delete(ArrayList<Student2> list) {
        if (list.size() == 0) {
            System.out.println("系统内暂无学生信息，请重试");
            System.out.println("\n");
            return;
        }
        int b = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号删除对应学生");
        String str = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(str, list.get(i).getId())) {
                b++;
                list.remove(i);
            }
        }
        if (b == 0)
            System.out.println("无该学号学生,删除失败");
        else
            System.out.println("删除成功!");
    }

    public static void Alter(ArrayList<Student2> list){
        int b=0;
        if (list.size() == 0) {
            System.out.println("系统内暂无学生信息，请重试");
            System.out.println("\n");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号修改对应学生信息");
        String str = sc.next();
        for (Student2 student2 : list) {
            if (Objects.equals(str, student2.getId())) {
                System.out.println("已查找到对应学生信息,信息如下:");
                System.out.print("学号:");
                System.out.println(student2.getId());
                System.out.print("姓名:");
                System.out.println(student2.getName());
                System.out.print("年龄:");
                System.out.println(student2.getAge());
                System.out.println("\n");
                System.out.println("修改学号----1");
                System.out.println("修改姓名----2");
                System.out.println("修改年龄----3");
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("请输入修改后的学号:");
                        student2.setId(sc.next());
                        b++;
                        break;
                    case 2:
                        System.out.println("请输入修改后的姓名:");
                        student2.setName(sc.next());
                        b++;
                        break;
                    case 3:
                        System.out.println("请输入修改后的学号:");
                        student2.setAge(sc.nextInt());
                        b++;
                        break;
                    default:
                        System.out.println("您输入的值有误,请重试");
                        break;
                }
            }
        }
        if (b == 0)
            System.out.println("无该学号学生,修改失败");
        else
            System.out.println("修改成功!");
    }
}


