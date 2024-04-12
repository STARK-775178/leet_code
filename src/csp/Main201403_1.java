package csp;

import java.util.*;

/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/2/28 17:02
 * @email fengyuzhuo666@gmail.com
 */
public class Main201403_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        if(nums[0]>=0){
            System.out.println(0);
            return;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            if(set.contains(Math.abs(nums[i]))){
                res++;
            }
            set.add(Math.abs(nums[i]));
        }
        System.out.println(res);
    }
}
