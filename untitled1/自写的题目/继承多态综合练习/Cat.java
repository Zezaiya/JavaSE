package 继承多态综合练习;

public class Cat extends Animal{
    public Cat(){}
    public Cat(int age,String color){
        super(age,color);
    }
    public void catchMouse(){
        System.out.println("猫在抓老鼠");
    }
    @Override
    public void Eat(String something){
        System.out.println("眯着眼睛侧着头吃"+something);
    }
}
