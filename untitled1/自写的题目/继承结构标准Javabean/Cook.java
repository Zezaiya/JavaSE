package 继承结构标准Javabean;

public class Cook extends Employ {
    public Cook() {
        this("Null","Null",0);
    }
    public Cook(String Id,String Name,int Salary) {
        super(Id,Name,Salary);
    }
    @Override
    public void Work() {
        System.out.println("在炒菜");
    }

    @Override
    public void Eat() {
        System.out.println("在吃米饭");
    }
}
