import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {

          /*File file2 = new File("D:\\File");
        boolean flag1 = file2.mkdir();                                           //创建文件夹,存在即不创建
        System.out.println(flag1);*/

          /*File file1 = new File("D:\\File\\file\\newFile1.txt");
        boolean flag2 = file1.createNewFile();                                   //创建一个普通文件
        System.out.println(flag2);*/

          /*File file3 = new File("D:\\File\\file");
        boolean flag3 = file3.mkdirs();                                          //创建多级文件夹
        System.out.println(flag3);*/

          /* File file4=new File("D:\\File\\file");
        boolean flag4=file4.delete();                                            //删除指定文件
        System.out.println(flag4);*/

          /* File file5 = new File("D:\\File\\file\\newFile1.txt");
        boolean flag5 = file5.exists();                                          //判断指定路径文件是否存在
        System.out.println(flag5);*/

          /* File file6 = new File("D:\\File\\file\\newFile1.txt");
        long flag6 = file6.length();                                             //获取文件大小,一个汉字3个字节,一个字母1个字节
        System.out.println(flag6);
        String flag7=file6.getName();                                            //获取文件名
        System.out.println(flag7);
        String flag8=file6.getPath();                                            //获取文件绝对路径
        System.out.println(flag8);*/

        showFiles("D:\\");

    }
    public static void showFiles(String pathname) {
        File file7 = new File(pathname);
        if (file7.isDirectory()) {                                                //先对传入的路径对应的文件进行判断,如果是文件夹执行1
            File[] files = file7.listFiles();                                     //如果不是文件夹输出:指定文件不是文件夹
            for (int i = 0;files!=null && i < files.length; i++) {                //1:循环判断文件夹里的文件,如果出现文件夹,则执行再次调用showFiles方法
                if (files[i].isDirectory()) {                                                          //如果不是文件夹,则输出文件的路径
                   showFiles(files[i].getPath());
                }                                                                  //这种在函数内调用自己方法称为函数递归
                else{
                    System.out.println("普通文件----"+file7.getPath());
                }
            }
        } else
            System.out.println("普通文件----"+file7.getPath());
    }

}
