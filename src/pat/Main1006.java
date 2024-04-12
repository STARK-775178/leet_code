package pat;
import java.util.*;
/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/2/26 19:21
 * @email fengyuzhuo666@gmail.com
 */


public class Main1006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        in.nextLine();

        String firstId;
        String endId;
        String firstTime;
        String endTime;
        if(M >= 1){
            String[] strings = in.nextLine().split(" ");
            firstId = strings[0];
            endId = strings[0];
            firstTime = strings[1];
            endTime = strings[2];
        }else{
            return;
        }
        for(int i = 0;i < M-1;i++){
            String[] strings = in.nextLine().split(" ");
            //判断first  如果左边更早 为true
            if(!isGreater(firstTime,strings[1])){
                firstTime = strings[1];
                firstId = strings[0];
            }
            //判断end
            if(isGreater(endTime,strings[2])){
                endTime = strings[2];
                endId = strings[0];
            }
        }
        System.out.println(firstId+" "+endId);

    }
    /**
     * 3
     * CS301111 15:30:28 17:00:10
     * SC3021234 08:00:00 11:25:25
     * CS301133 21:45:00 21:58:40
     *
     */
    private static boolean isGreater(String firstTime, String string) {
        String[] s1 = firstTime.split(":");
        String[] s2 = string.split(":");
        int h1 = Integer.parseInt(s1[0]);
        int h2 = Integer.parseInt(s2[0]);
        if(h1 < h2){
            return true;
        }else if(h1 > h2){
            return false;
        }
        int m1 = Integer.parseInt(s1[1]);
        int m2 = Integer.parseInt(s2[1]);
        if(m1 < m2){
            return true;
        } else if (m1 > m2) {
            return false;
        }

        int second1 = Integer.parseInt(s1[2]);
        int second2 = Integer.parseInt(s2[2]);
        if(second1 < second2){
            return true;
        }else if(second1 > second2){
            return false;
        }

        return true;
    }
}
