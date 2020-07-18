package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int id = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(scanner.nextLine()));
        String str = "";
        char ch;
        char[] cbuf = new char[100];
        int len = 0;
        while (inputStreamReader.ready()) {
            len = inputStreamReader.read(cbuf, len+1, 50);
            str += cbuf.toString();
        }
        String[] data = str.split("\n");
        for (int i = 0; i < data.length; i++) {
            String[] row = data[i].split(" ");
            if (row[0].equals(args[0])) {
                System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3]);
                break;
            }
        }
        inputStreamReader.close();
    }
}

