package 继承多态综合练习;

public class Animal {
    private int Age;
    private String Color;

    public Animal() {
    }

    public Animal(int age, String color) {
        this.Age = age;
        this.Color = color;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getAge() {
        return Age;
    }

    public String getColor() {
        return Color;
    }

    public void Eat(String something) {
        System.out.println("在吃" + something);
    }
    public static void KeepPet(Person p, Animal a, String something) {
        if (a instanceof Dog) {
            Dog d = (Dog) a;//将动物类转换成狗类，则变量是狗类的，方法则是动物类提供的
            System.out.println("年龄为" + p.getAge() + "岁的" + p.getName() + "养了一只" + d.getColor() + "的狗");
            System.out.print(d.getAge() + "岁的" + d.getColor() + "狗");
            d.Eat(something);
        }
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            System.out.println("年龄为" + p.getAge() + "岁的" + p.getName() + "养了一只" + c.getColor() + "的猫");
            System.out.print(c.getAge() + "岁的" + c.getColor() + "猫");
            c.Eat(something);
        }
    }
}
