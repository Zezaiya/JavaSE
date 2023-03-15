package 开发验证码;
//这里规定五位数验证码
//3个字母，2个数字
//用StringBuild会更好
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        Random r = new Random();
        StringBuilder result = new StringBuilder();
        char[] arr = new char[52];
        for (int i = 0; i < 26; i++) {
            arr[i] = (char) (65 + i);
        }
        for (int i = 26; i < 52; i++) {
            arr[i] = (char) (97 + i - 26);
        }
        for (int i = 0; i < 5; i++) {
            int a = r.nextInt(10);
            int b = r.nextInt(2);
            int c = r.nextInt(arr.length);
            if (b == 0){
                if (n == 3) {
                    i--;
                    continue;
                }
            result.append(arr[c]);
            n++;
            }
            if (b == 1) {
                if (m == 2) {
                    i--;
                    continue;
                }
                result.append(a);
                m++;
            }
        }
        System.out.println(result);//这里输出的不是对象的地址,而是属性值
    }
}
