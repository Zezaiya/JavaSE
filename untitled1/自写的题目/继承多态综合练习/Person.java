package 继承多态综合练习;

public class Person {
    private String Name;
    private int Age;

    public Person(){}
    public Person(String name,int age){
        Name=name;
        Age=age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }
}
