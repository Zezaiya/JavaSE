package 手机号屏蔽;

public class Phone {
    private String tel;

    public Phone(){}

    public Phone(String tel){
        this.tel=tel;
    }

    public void setTel(String tel){
        this.tel=tel;
    }

    public String getTel(){return tel;}

    public void Fun(String tel){
       char[] arr=new char[11];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=tel.charAt(i);//字符串索引
        }
        for (int i =3; i < 7; i++) {
            arr[i]='*';
        }
        String Tel=new String(arr);
        this.tel=Tel;
    }

    public int Judge(String tel){
        if(tel.length()!=11)
            return 0;
        else
            return 1;
    }
}
