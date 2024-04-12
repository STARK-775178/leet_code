package pat;

import java.util.*;
import java.io.*;

/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/2/26 20:30
 * @email fengyuzhuo666@gmail.com
 */
public class Main1008 {
    public static void main(String[] args)   {
        /**
         * Sample Input:
         * 3 2 3 1
         * Sample Output:
         * 41
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        //每个楼梯停5秒
        res += N * 5;
        //初始楼层为0
        int current = 0;
        int[] nums = new int[N];
        String[] strings = sc.nextLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        for (int i = 0; i < N; i++) {
            if(nums[i]>current){
                res += (nums[i]-current)*6;
            }else{
                res += (current-nums[i])*4;
            }
            current = nums[i];
        }
        System.out.println(res);
    }
}
