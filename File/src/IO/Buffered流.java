package IO;

import java.io.*;
import java.nio.Buffer;

public class Buffered流 {
    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis();
        //在铺设BufferedStream管道时要先铺设FileStream管道
        FileInputStream fileInputStream=new FileInputStream("D:\\File\\file\\newFile1.txt");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\File\\file\\newFile2.txt");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);

        //因为BufferedInputStream里read方法的形参是byte数组,即我们需要定义一辆装定量数据的传输工具
        byte[] car=new byte[1024];   //一次性能装1024个字节,即1KB,同时,这也给了数据写的入一个缓冲空间,提高效率
        int a=0;
        while((a=bufferedInputStream.read(car))!=-1){
             bufferedOutputStream.write(car,0,a);   //表示一次性搬从car下标[0]开始到下标[a]这么多数据,防止浪费空间
        }
        long endTime=System.currentTimeMillis();
        System.out.println("共消耗"+(endTime-startTime)+"ms");

        bufferedInputStream.close();
    }


}
