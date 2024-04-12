package com.csp;

import java.util.*;
import java.util.Scanner;

/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/2/27 20:16
 * @email fengyuzhuo666@gmail.com
 */
public class Main201312_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Map<Integer,Integer> map = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            map.put(x,map.getOrDefault(x,0)+1);
            if(map.get(x)>maxValue){
                res = x;
                maxValue = map.get(x);
            }else if(map.get(x)==maxValue){
                if(x<res){
                    res = x;
                    maxValue = map.get(x);
                }
            }
        }
        System.out.println(res);
    }
}
