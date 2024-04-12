package com.csp;

import java.util.Scanner;

public class Main201312_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = 0;
        int index = 1;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) != '-') {
                res += (str.charAt(i) - '0') * index++;
            }
        }

        res %= 11;
        char expectedCode = (res == 10) ? 'X' : (char) (res + '0');

        if (expectedCode == str.charAt(12)) {
            System.out.println("Right");
        } else {
            System.out.println(str.substring(0, 12) + expectedCode);
        }
        sc.close();
    }
}