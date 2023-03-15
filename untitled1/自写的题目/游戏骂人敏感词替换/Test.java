package 游戏骂人敏感词替换;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] arr={"TMD","CNM","SB","MLGB","TM"};//敏感词库
        while(true) {
            System.out.println("请输入一句话,最好不要骂人哦:");
            String word = sc.next();
            for (int i = 0; i < arr.length; i++) {
                word=word.replace(arr[i],"***");
            }
                System.out.println(word);
        }
    }
}
