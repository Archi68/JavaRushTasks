package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        num1 = Integer.parseInt(reader.nextLine());
        num2 = Integer.parseInt(reader.nextLine());
        if (num1 <= 0 || num2 <= 0) throw new Exception();
        reader.close();

        int numLess = 0;
        int result = 1;
        if (num1 == 0) {
            result = num2;
        } else if (num2 == 0) {
            result = num1;
        } else {
            if (num1 < num2) {
                numLess = num1;
            } else {
                numLess = num2;
            }

            for (int i = 2; i <= numLess; i++) {
                if ((num1 % i) == 0 && (num2 % i) == 0) {
                    result = i;
                }
            }
        }
        System.out.println(result);
    }
}
