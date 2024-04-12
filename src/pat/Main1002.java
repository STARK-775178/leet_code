
package com.fyz;

import java.util.*;


public class Main1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Double> map = new HashMap<>();
        int max = 0;
        for (int k = 0; k < 2; k++) {
            int loop1 = in.nextInt();
            for (int i = 0; i < loop1; i++) {

                int a = in.nextInt();
                double b = in.nextDouble();
                max = Math.max(max, a);
                if (map.containsKey(a)) {
                    map.put(a, b + map.get(a));
                } else {
                    map.put(a, b);
                }
            }
            in.nextLine();
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();


        for (int i = max; i >= 0; i--) {
            if (map.containsKey(i)) {
                if (map.get(i) == 0) {
                    continue;
                }
                {
                    count++;
                    sb.append(i + " " + String.format("%.1f",map.get(i)) + " ");
                }

            } else {
                continue;
            }
        }
        System.out.println(count + " " + sb.toString().trim());

    }
}
