package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File fileIn = new File(args[0]);
        FileReader fileReader = new FileReader(fileIn);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        char ch;
        int count = 0;
        while ((ch = (char) bufferedReader.read()) != 65535) {
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
                count++;
        }
        bufferedReader.close();
        System.out.println(count);
    }
}
