package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        BigInteger factorial = BigInteger.valueOf(1);
        if (n < 0) {
            return "0";
        } else if (n > 150) {
            System.out.println("Число должно быть меньше либо равно 150");
            return "";
        }
        for (BigInteger i = BigInteger.valueOf(n); i.compareTo(BigInteger.valueOf(1)) == 1; i = i.subtract(BigInteger.valueOf(1))) {
            factorial = factorial.multiply(i);
        }


        return String.valueOf(factorial);
    }
}
