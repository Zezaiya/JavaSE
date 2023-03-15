package 继承多态综合练习;

public class Dog extends Animal {
    public Dog(){}
    public Dog(int age,String color){
        super(age,color);
    }
    public void lookHome(){
        System.out.println("狗在看家");
    }
    @Override
    public void Eat(String something){
        System.out.println("两只前腿死死的抱住"+something+"猛吃");
    }
}
