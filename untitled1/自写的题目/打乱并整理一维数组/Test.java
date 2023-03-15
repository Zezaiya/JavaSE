package 打乱并整理一维数组;
//将一个给定的一维数组打乱,并以4个为一组放到二维数组里

import java.util.Random;

public class Test {
    public static void main(String[] args) {//方法一：遍历数组，取随机索引，将索引数组与遍历数组进行交换
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[][] arr = new int[4][4];
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int a = r.nextInt(tempArr.length);
            int tmp = tempArr[i];
            tempArr[i] = tempArr[a];
            tempArr[a]=tmp;
        }
        int n=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=tempArr[n];
                n++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j]+" "+"\t");
            }
            System.out.println();
        }
    }
    /*public static void main(String[] args) {//方法二:每取一个索引都要进行比较，将每次存入数组索引对应的值存入新数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[][] arr = new int[4][4];
        int[] cmp = new int[16];//存储已经放入的字符串，防止重复的索引
        Random r = new Random();
        int b = 0;
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] Arr = new int[4];
            for (int j = 0; j < arr.length; j++) {
                int m = 0;
                int a = r.nextInt(tempArr.length);
                if (i == 0 && j == 0) {
                    Arr[j] = tempArr[a];
                    cmp[n] = tempArr[a];
                    n++;
                } else {
                    for (int k = 0; k < n; k++) {
                        if (tempArr[a] == cmp[k]) {
                            m++;
                            break;
                        }
                    }
                    if (m == 0) {
                        Arr[j] = tempArr[a];
                        cmp[n] = tempArr[a];
                        n++;
                    } else {
                        j--;
                    }
                }
            }
            arr[i] = Arr;//一维数组作为二维数组的一行
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " " + "\t");
            }
            System.out.print("\n");
        }
    }*/
}
