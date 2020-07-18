package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file1 = new File(scanner.nextLine()); //"/Users/moisej/Downloads/первый.txt");
        File file2 = new File(scanner.nextLine()); //"/Users/moisej/Downloads/второй.txt");
        FileReader fileReader = new FileReader(file1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String st = bufferedReader.readLine();
        String[] data = st.split(" ");

        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        for (String str : data) {
            bufferedWriter.write(Integer.valueOf(Math.round(Float.valueOf(str))).toString());
            bufferedWriter.write(" ");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
