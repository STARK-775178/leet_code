package pat;
import java.util.*;
/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/2/14 11:26
 * @email fengyuzhuo666@gmail.com
 */
public class Main1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a+b;
        if(c>=-999&&c<=999) {
            System.out.println(c);
            return;
        }
        if(c<0){
            System.out.print("-");
            c = -c;
        }

        String res = String.valueOf(c);
        int len = res.length();
        StringBuilder sb = new StringBuilder();
        int loop = 0;
        for(int i = len-1;i>=0;i--){
            sb.append(res.charAt(i));
            loop++;
            if(loop%3==0&&i!=0){
                sb.append(",");
            }
        }
        System.out.println(sb.reverse().toString());
    }
}