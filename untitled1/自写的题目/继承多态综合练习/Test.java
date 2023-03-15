package 继承多态综合练习;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("老王");
        p.setAge(30);
        Dog d = new Dog(2, "黑色");
        Cat c = new Cat(3, "灰色");
        Animal a = new Animal();
        a.KeepPet(p, c, "鱼");//修改参数(动物种类)就可以打印不同结果
        a.KeepPet(p, d, "骨头");//修改参数(动物种类)就可以打印不同结果
    }
}
