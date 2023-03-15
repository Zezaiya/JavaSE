package 继承结构标准Javabean;

public class Employ {
    private String Id;
    private String Name;
    private int Salary;
    public Employ(){}
    public Employ(String id,String name,int salary){
        Id = id;
        Name = name;
        Salary = salary;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getSalary() {
        return Salary;
    }
    public void Work(){
        System.out.println("在工作");
    }
    public void Eat(){
        System.out.println("在吃饭");
    }
}
