package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File fileIn = new File(args[0]);
        FileReader fileReader = new FileReader(fileIn);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        char ch;
        int countWhiteSpace = 0;
        int countLetter = 0;
        while ((ch = (char) bufferedReader.read()) != 65535) {
            //if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
            if (ch == ' ')
                countWhiteSpace++;
            countLetter++;
        }
        bufferedReader.close();
        System.out.printf("%.2f", (double) countWhiteSpace*100/countLetter);
    }
}
