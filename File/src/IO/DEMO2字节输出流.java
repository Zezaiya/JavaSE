package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DEMO2字节输出流 {
    public static void main(String[] args) throws IOException {
        //准备数据
        String data="hello motherfucker";
        //铺设道路
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\File\\file\\newFile1.txt",true);   //FileOutputStream还有一个构造参数append,表示追加还是覆盖内容
        //开始传输
        byte[] Data =data.getBytes(StandardCharsets.UTF_8);   //这里使用字节数组写入的方法,所以要先将data变为字节数组
        fileOutputStream.write(Data);
        //关闭通道
        fileOutputStream.close();
    }
}
