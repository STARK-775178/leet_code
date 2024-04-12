package csp;

import java.util.Scanner;

/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/2/27 21:27
 * @email fengyuzhuo666@gmail.com
 */
public class Main201312_3 {
    public static void main(String[] args) {
        /**
         * 6
         * 3 1 6 5 2 3
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N - 1; i++) {
            int min = nums[i];
            for (int j = i+1; j < N; j++) {
                min = Math.min(min,nums[j]);
                max = Math.max((j-i+1)*min,max);
            }
        }
        System.out.println(max);
    }
}
