package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        //В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
        //Закрыть потоки.
        Scanner scanner = new Scanner(System.in);
        File file1 = new File(scanner.nextLine());
        File file2 = new File(scanner.nextLine());
        FileInputStream fileIS1 = new FileInputStream(file1);
        FileInputStream fileIS2 = new FileInputStream(file2);

        byte[] buffer = new byte[fileIS1.available() + fileIS2.available()];
        fileIS1.read(buffer, fileIS2.available(), fileIS1.available());
        fileIS2.read(buffer);
        fileIS1.close();
        fileIS2.close();

        FileOutputStream fileOS = new FileOutputStream(file1);
        fileOS.write(buffer);
        fileOS.close();
    }
}
