package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fName1 = scanner.nextLine();
        //String fName1 = "/Users/moisej/Downloads/первый.txt";
        //Users/moisej/Downloads/первый.txt
        String fName2 = scanner.nextLine();
        //String fName2 = "/Users/moisej/Downloads/второй.txt";
        FileInputStream file1 = new FileInputStream(fName1);
        byte[] array = new byte[file1.available()];
        while (file1.available() > 0) {
            file1.read(array);
        }
        FileOutputStream file2 = new FileOutputStream(fName2);
        for (int i = array.length-1; i >= 0 ; i--) {
            file2.write(array[i]);
        }

        file1.close();
        file2.close();
    }
}
