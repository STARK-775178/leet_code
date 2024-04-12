package com.csp;
import java.util.*;

public class Main202312_2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            long n = sc.nextLong();
            int k = sc.nextInt();
            runQuery(n, k);
        }
    }

    private static void runQuery(long n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                while (n % i == 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    n = n / i;
                }
            }
        }

        double res = 1;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() >= k) {
                res *= Math.pow(entry.getKey(), entry.getValue());
            }
        }
        System.out.println((long) res);
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}