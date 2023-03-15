package 身份证查出生日期和性别;

public class Code {
    private String Id;

    public Code(){}
    public Code(String Id){}
    public void setId(String Id){
        this.Id=Id;
    }
    public String getId(){return Id;}

    public void Fun(String Id){
        String Year=Id.substring(6,10);
        String Month=Id.substring(10,12);
        String Day=Id.substring(12,14);
        char arr=Id.charAt(16);
        if(arr%2==0)
            System.out.println("出生日期:" + Year + "年" + Month + "月" + Day + "日"+"\n"+"性别:女");
        else
            System.out.println("出生日期:" + Year + "年" + Month + "月" + Day + "日"+"\n"+"性别:男");
    }
}
