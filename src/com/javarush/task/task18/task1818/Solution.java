package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file1 = new File(scanner.nextLine());
        File file2 = new File(scanner.nextLine());
        File file3 = new File(scanner.nextLine());
        FileInputStream fileIS = new FileInputStream(file2);
        FileOutputStream fileOS = new FileOutputStream(file1);
        int read;
        while ((read = fileIS.read()) != -1) {
            fileOS.write(read);
        }
        fileIS.close();
        fileOS.close();

        FileOutputStream fileOS1 = new FileOutputStream(file1, true);
        FileInputStream fileIS1 = new FileInputStream(file3);
        while ((read = fileIS1.read()) != -1) {
            fileOS1.write(read);
        }
        fileIS1.close();
        fileOS1.close();
    }
}
