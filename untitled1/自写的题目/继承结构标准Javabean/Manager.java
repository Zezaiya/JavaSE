package 继承结构标准Javabean;

public class Manager extends Employ {
    double Bonus;
    public Manager() {
        this("Null","Null",0,0);
    }
    public Manager(String Id,String Name,int Salary,double bonus) {
        super(Id,Name,Salary);
        this.Bonus=bonus;
    }
    @Override
    public void Work() {
        System.out.println("在管理其他人");
    }

    @Override
    public void Eat() {
        System.out.println("在吃蛋炒饭");
    }
}
