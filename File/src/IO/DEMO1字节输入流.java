package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DEMO1字节输入流 {
    public static void main(String[] args) throws IOException {
        //铺设道路(方法一)直接传路径进行构造
        //FileInputStream fileInputStream=new FileInputStream("D:\\File\\file\\newFile1.txt");

        //铺设道路(方法二)传入文本类型进行构造(推荐)->因为这样可以先对文本是否有内容进行判断,减少无用功
        File file=new File("D:\\File\\file\\newFile1.txt");   //->此处已经准备好了数据
        FileInputStream fileInputStream=new FileInputStream(file);

        //传输数据
        //方法一
       /* for (int i = 0; i < file.length(); i++) {
            int a=fileInputStream.read();
            System.out.print((char)a);
        }*/

        //方法二(常用)
        int a=0;
        while((a=fileInputStream.read())!=-1){
            System.out.print(a);
        }


        //关闭道路
        fileInputStream.close();
    }
}
