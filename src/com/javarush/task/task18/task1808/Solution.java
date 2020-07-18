package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fName1 = scanner.nextLine();
        //Users/moisej/Downloads/первый.txt
        String fName2 = scanner.nextLine();
        String fName3 = scanner.nextLine();
        FileInputStream file1 = new FileInputStream(fName1);
        FileOutputStream file2 = new FileOutputStream(fName2);
        FileOutputStream file3 = new FileOutputStream(fName3);
        int fileSize = file1.available();
        int count = 0;
        if (fileSize % 2 != 0) {
            count = fileSize / 2 + 1;
        } else {
            count = fileSize / 2;
        }
        byte[] buffer  = new byte[fileSize];
        file1.read(buffer, 0, fileSize);
        file2.write(buffer, 0, count);
        file3.write(buffer, count, fileSize-count);

        file1.close();
        file2.close();
        file3.close();
    }
}

