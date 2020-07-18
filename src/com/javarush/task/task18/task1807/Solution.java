package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ///Users/moisej/Downloads/первый.txt
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        int count=0;
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            if (inputStream.read() == ',') {
                count++;
            }
        }
        System.out.print(count);

        inputStream.close();
    }
}
