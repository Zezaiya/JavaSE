package 数组版学生管理系统;

import java.util.Objects;

public class Student1 {
    private String Id;
    private String Name;
    private int Age;

    public Student1(){}//空参构造

    public Student1(String Id, String Name, int Age){//全参构造
        this.Id=Id;
        this.Name=Name;
        this.Age=Age;
    }
    public int getAge(){return Age;}
    public String getId(){return Id;}
    public String getName(){return Name;}

    public void setId(String Id){
        this.Id=Id;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public void setAge(int Age){
        this.Age=Age;
    }

    public int Judge(String aId,String bId){
        if(Objects.equals(aId, bId))
        {
            return 0;
        }
        else
            return 1;
    }
}
