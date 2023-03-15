package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//将newFile1文本内容复制到newFile2中
public class DEMO3输入输出综合 {
    public static void main(String[] args) throws IOException {
        File file1=new File("D:\\File\\file\\newFile1.txt");
        File file2=new File("D:\\File\\file\\newFile2.txt");
        FileInputStream fileInputStream=new FileInputStream(file1);
        FileOutputStream fileOutputStream=new FileOutputStream(file2);
        int a=0;
        while ((a=fileInputStream.read())!=-1){
            fileOutputStream.write(a);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
