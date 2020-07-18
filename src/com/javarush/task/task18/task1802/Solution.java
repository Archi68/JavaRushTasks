package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        int minValue = 1000;
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            if (minValue > data) {
                minValue = data;
            }
        }
        inputStream.close();
        System.out.println(minValue);
    }
}
